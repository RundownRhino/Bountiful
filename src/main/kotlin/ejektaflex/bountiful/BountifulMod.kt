package ejektaflex.bountiful

import net.alexwells.kottle.FMLKotlinModLoadingContext
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

@Mod("bountiful")
object BountifulMod {

    val logger: Logger = LogManager.getLogger()

    val configFolder = Paths.get("config", "bountiful").toFile().apply {
        mkdirs()
    }

    val configDecrees = File(configFolder, "decrees").apply {
        mkdirs()
    }

    val configPools = File(configFolder, "pools").apply {
        mkdirs()
    }

    init {

        FMLKotlinModLoadingContext.get().modEventBus.apply {

            addListener<RegistryEvent.Register<Item>> { SetupLifecycle.registerItems(it) }

        }
    }

    // Temporary dummy config until real config files are replaced
    val config = ConfigDummy()

}