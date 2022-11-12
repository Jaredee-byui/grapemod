package jellis.grapemod.init;


import jellis.grapemod.Grapemod;
import jellis.grapemod.util.ModSoundEvents;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Grapemod.MOD_ID);

    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModCreativeTab.instance).food(
                    new Food.Builder().hunger(2).saturation(1).build())));

    public static final RegistryObject<Item> GRAPEOFWRATH = ITEMS.register("grapeofwrath",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModCreativeTab.instance).food(
                    new Food.Builder().hunger(2).saturation(1)
                            .effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 5, 0), 0.8F)
                            .build())));

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().maxStackSize(16).group(ModCreativeTab.instance).food(
                    new Food.Builder().hunger(2).saturation(1)
                            .effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 5, 0), 0.8F)
                            .build())));

    public static final RegistryObject<Item> LEMONADE = ITEMS.register("lemonade",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModCreativeTab.instance).food(
                    new Food.Builder().hunger(4).saturation(2)
                            .effect(() -> new EffectInstance(Effects.HASTE, 200, 0), 0.5f)
                            .effect(() -> new EffectInstance(Effects.SPEED, 200, 0), 0.5f)
                            .build())));

    public static final RegistryObject<Item> GRAPEDISC = ITEMS.register("grapedisc",
            () -> new MusicDiscItem(1, () -> ModSoundEvents.grapedisc.get(),
                    new Item.Properties().maxStackSize(1).group(ModCreativeTab.instance)));


    public static class ModCreativeTab extends ItemGroup {
        public static final ModCreativeTab instance = new ModCreativeTab(ItemGroup.GROUPS.length, "grapemod");
        private <string> ModCreativeTab(int index, String label){
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(GRAPE.get());
        }

    }

}
