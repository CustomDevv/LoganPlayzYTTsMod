package net.mcreator.loganplayzytts_mod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;

@Elementsloganplayzytts_mod.ModElement.Tag
public class MCreatorTestKEYOnKeyPressed extends Elementsloganplayzytts_mod.ModElement {
	public MCreatorTestKEYOnKeyPressed(Elementsloganplayzytts_mod instance) {
		super(instance, 2);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MCreatorTestKEYOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MCreatorTestKEYOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MCreatorTestKEYOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorTestKEYOnKeyPressed!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 4, true);
		}
	}

	@SubscribeEvent
	public void onCommand(CommandEvent event) {
		ICommandSender sender = event.getSender();
		Entity entity = sender.getCommandSenderEntity();
		if (entity != null) {
			int i = (int) sender.getPosition().getX();
			int j = (int) sender.getPosition().getY();
			int k = (int) sender.getPosition().getZ();
			String command = event.getCommand().getName();
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("command", command);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
