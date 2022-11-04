package jellis.grapemod.init;

import jellis.grapemod.Grapemod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.lwjgl.system.CallbackI;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Grapemod.MOD_ID);

    public static final RegistryObject<Block> GRAPE_ORE = BLOCKS.register("grape_ore",
            () -> new OreBlock(AbstractBlock.Properties.from(Blocks.COAL_ORE)));

    public static final RegistryObject<Block> LEMON_ORE = BLOCKS.register("lemon_ore",
            () -> new OreBlock(AbstractBlock.Properties.from(Blocks.COAL_ORE)));

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block -> {

            final Item.Properties properties = new Item.Properties().group(ItemInit.ModCreativeTab.instance);

            final BlockItem blockItem = new BlockItem(block, properties);

            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        }));
    }
}
