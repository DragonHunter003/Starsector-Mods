package data.console.commands.weapons;

import java.util.ArrayList;
import java.util.List;
import com.fs.starfarer.api.Global;
import com.fs.starfarr.api.campaign.*;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import com.fs.starfarer.api.loading.WeaponSlotAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.campaign.FleetAssignment;
import org.lazywizard.console.BaseCommand;
import org.lazywizard.console.CommonStrings;
import org.lazywizard.console.Console;

public class ExtraAddWeaponToSlot implements BaseCommand
{
	@Override
	public CommandResult runCommand(String args, CommandContext context)
	{
		if(!context.isInCampaign())
		{
			Console.showMessage(CommonStrings.ERROR_CAMPAIGN_ONLY);
			return CommandResult.WRONG_CONTEXT;
		}
	
		FleetMemberAPI playerFlagship = Global.getSector().getPlayerFleet().getFlagship();
		List<WeaponSlotAPI> shipWeaponSlotsList = playerFlagship.getHullSpec().getAllWeaponSlotsCopy();

		for(WeaponSlotAPI weaponSlot: shipWeaponSlotsList)
		{
			Console.showMessage( weaponSlot.getId() + " " + playerFlagship.getVariant().getWeaponId(weaponSlot.getId()));
		}
	
		return CommandResult.SUCCESS;
	}
}