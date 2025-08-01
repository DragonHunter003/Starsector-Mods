package data.hullmods;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.combat.ShieldAPI.*;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.CombatEntityAPI;
import com.fs.starfarer.api.combat.ShipSystemAPI;
import com.fs.starfarer.api.combat.FluxTrackerAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.combat.BaseShipSystemScript;

public class HermesDrive extends BaseHullMod 
{
	static float MAX_SPEED_BONUS = 75;
	static float MAX_BURN_BONUS = 3;
	static float FUEL_CONSUMPTION_REDUCTION_MULTIPLIER = 0.5f;
	
	public String getDescriptionParam(int index, HullSize hullSize)
	{
		if (index == 0)
		{
            return "" + MAX_SPEED_BONUS;
        }
		if (index == 1)
		{
            return "" + MAX_BURN_BONUS;
        }
		if (index == 2)
		{
			return "" + ((1f-FUEL_CONSUMPTION_REDUCTION_MULTIPLIER)*100)+"%";
		}
		return null;
	}
	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id)
	{
		stats.getMaxSpeed().modifyFlat(id, MAX_SPEED_BONUS);
		stats.getMaxBurnLevel().modifyFlat(id, MAX_BURN_BONUS);
		stats.getFuelUseMod().modifyMult(id, FUEL_CONSUMPTION_REDUCTION_MULTIPLIER);
	}
}