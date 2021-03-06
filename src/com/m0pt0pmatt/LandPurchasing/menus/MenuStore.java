package com.m0pt0pmatt.LandPurchasing.menus;

import org.bukkit.command.CommandSender;

import com.m0pt0pmatt.LandPurchasing.LandPurchasing;
import com.m0pt0pmatt.menuservice.api.Menu;
import com.m0pt0pmatt.menuservice.api.rendering.Renderer;

public class MenuStore {

	private MenuPartStore parts;
		
	private Renderer inventoryRenderer;
	
	public MenuStore(){
		inventoryRenderer = LandPurchasing.menuService.getRenderer("inventory");
		
		parts = new MenuPartStore();
		
	}
	
	private Menu createMainMenu(CommandSender player, int startIndex){
		Menu mainMenu = new Menu();
		mainMenu.addPart(parts.createLandList(player.getName(), startIndex));
		mainMenu.setSize(5);
		return mainMenu;
	}
	
	/**
	 * Opens the LandMenu: A graphical interface for most land-related commands
	 * @param player
	 */
	public void openMainMenu(CommandSender player) {
		inventoryRenderer.openMenu(createMainMenu(player, 0), player.getName());
	}
	
	public void openPlotMenu(CommandSender player, String plotName){
		
		Menu plotMenu = new Menu();
		
		inventoryRenderer.openMenu(plotMenu, player.getName());
	}
}
