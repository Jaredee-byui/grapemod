package jellis.grapemod.init;


import jellis.grapemod.Grapemod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Grapemod.MOD_ID);

    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties()));


    /*public static class ModCreativeTab extends ItemGroup {
        private <string> ModCreativeTab(int index, string label){
            super(index, label);
        }

        @Override
        public ItemStack makeIcon(){
            return new ItemStack(GRAPE.get());
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(GRAPE.get());
        }
    }*/
}
