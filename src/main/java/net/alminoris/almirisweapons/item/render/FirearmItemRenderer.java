package net.alminoris.almirisweapons.item.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.alminoris.almirisweapons.item.custom.AbstractFirearmItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FirearmItemRenderer extends BlockEntityWithoutLevelRenderer {

    private static final Map<UUID, Map<InteractionHand, Float>> recoilMap = new HashMap<>();
    private static final Map<UUID, Map<InteractionHand, Integer>> reloadMap = new HashMap<>();
    private static final RandomSource random = RandomSource.create();

    public FirearmItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(),
                Minecraft.getInstance().getEntityModels());
    }

    public static void triggerRecoil(UUID player, InteractionHand hand, double strength) {
        recoilMap.computeIfAbsent(player, k -> new HashMap<>()).put(hand, (float) strength);
    }

    public static void startReload(UUID player, InteractionHand hand, int ticks) {
        reloadMap.computeIfAbsent(player, k -> new HashMap<>()).put(hand, ticks);
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext,
                             PoseStack poseStack, MultiBufferSource buffer,
                             int packedLight, int packedOverlay) {

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        UUID playerId = mc.player.getUUID();
        InteractionHand hand = mc.player.getMainHandItem() == stack
                ? InteractionHand.MAIN_HAND
                : InteractionHand.OFF_HAND;

        float recoilOffset = recoilMap.getOrDefault(playerId, Map.of()).getOrDefault(hand, 0f);
        int reloadTicks = reloadMap.getOrDefault(playerId, Map.of()).getOrDefault(hand, 0);
        int maxReloadTicks = reloadTicks;

        if (recoilOffset > 0) {
            if (stack.getItem() instanceof AbstractFirearmItem firearm) {
                String id = firearm.getDescriptionId();

                if (id.contains("arquebus")) {
                    poseStack.translate(0, 0, -recoilOffset * 1.2f);
                    poseStack.mulPose(Axis.XP.rotationDegrees(-recoilOffset * 15f));
                } else if (id.contains("blunderbuss")) {
                    poseStack.translate((random.nextFloat() - 0.5f) * 0.05f, 0, -recoilOffset * 1.5f);
                    poseStack.mulPose(Axis.XP.rotationDegrees(-recoilOffset * 20f));
                } else if (id.contains("pistol")) {
                    poseStack.translate(0, 0, -recoilOffset * 0.6f);
                    poseStack.mulPose(Axis.XP.rotationDegrees(-recoilOffset * 5f));
                }
            }

            recoilOffset *= 0.75f;
            if (recoilOffset < 0.01f) recoilOffset = 0f;
            recoilMap.computeIfAbsent(playerId, k -> new HashMap<>()).put(hand, recoilOffset);
        }

        if (reloadTicks > 0) {
            float progress = 1.0f - (reloadTicks / (float) maxReloadTicks);
            poseStack.translate(0, progress * -0.4f, progress * 0.2f);
            poseStack.mulPose(Axis.XP.rotationDegrees(progress * 25.0f));
            reloadTicks--;
            reloadMap.computeIfAbsent(playerId, k -> new HashMap<>()).put(hand, reloadTicks);
        }

        ItemRenderer renderer = mc.getItemRenderer();
        BakedModel model = renderer.getModel(stack, mc.level, mc.player, 0);
        renderer.render(stack, displayContext, false, poseStack, buffer, packedLight, packedOverlay, model);
    }
}