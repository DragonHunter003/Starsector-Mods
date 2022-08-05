package data.console.commands.hullmod;

import java.util.ArrayList;
import java.util.List;
import com.fs.starfarer.api.Global;
import com.fs.starfarr.api.campaign.*;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import com.fs.starfarer.api.campaign.FleetAssignment;
import org.lazywizard.console.BaseCommand;
import org.lazywizard.console.CommonStrings;
import org.lazywizard.console.Console;

public class ExtraAddPermaHullmod implements BaseCommand
{
	
    public static List<String> getHullMods()
    {
        final List<String> hullmods = new ArrayList<String>(Global.getSettings().getAllHullModSpecs().size());
        for (HullModSpecAPI spec : Global.getSettings().getAllHullModSpecs())
        {

                hullmods.add(spec.getId());
        }

        return hullmods;
    }

    @Override
    public CommandResult runCommand(String args, CommandContext context)
    {
        if (!context.isInCampaign())
        {
            Console.showMessage(CommonStrings.ERROR_CAMPAIGN_ONLY);
            return CommandResult.WRONG_CONTEXT;
        }
		
		if (args.isEmpty())
        {
            return CommandResult.BAD_SYNTAX;
        }
		
		if (getHullMods().contains(args))
        {
            CampaignFleetAPI player = Global.getSector().getPlayerFleet();
			player.getFlagship().getVariant().addPermaMod(args);
			Console.showMessage("Added "+args+" to your flagship.");
			return CommandResult.SUCCESS;
        }
		else
		{     
            Console.showMessage("No modspec found with id '" + args
                    + "'! Use 'list hullmods' for a complete list of valid ids.");
            return CommandResult.ERROR;
		}		
    }
}