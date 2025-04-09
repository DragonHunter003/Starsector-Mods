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

public class CharonBlackhole extends BaseHullMod 
{
	static float CARGO_BONUS_MULTIPLIER = 2.5f;
	static float FUEL_BONUS_MULTIPLIER = 1.5f;
	
	public String getDescriptionParam(int index, HullSize hullSize)
	{
		if (index == 0) {
            return ""+(CARGO_BONUS_MULTIPLIER*100)+"%";
        }
		if (index == 1) {
            return "" + (FUEL_BONUS_MULTIPLIER*100)+"%";
        }
		return null;
	}
	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id)
	{
		stats.getCargoMod().modifyMult(id, CARGO_BONUS_MULTIPLIER);
		stats.getFuelMod().modifyMult(id, FUEL_BONUS_MULTIPLIER);
	}
}