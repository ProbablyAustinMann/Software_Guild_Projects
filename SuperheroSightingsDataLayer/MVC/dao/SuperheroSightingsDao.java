/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Hero;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author austinmann
 */
public interface SuperheroSightingsDao {
    
//==============================================================================
//HERO METHODS
//==============================================================================
    public void addHero(Hero hero);
    public void deleteHero(int id);
    public void updateHero(Hero hero);
    public Hero getHeroById(int id);
    public List<Hero> getAllHeros();
//==============================================================================
//SIGHTING METHODS
//==============================================================================
    public void addSighting(Sighting sighting);
    public void deleteSighting(int sightingId);
    public void updateSighting(Sighting sighting);
    public Sighting getSightingById(int id);
    public List<Sighting> getAllSightings();
//==============================================================================
//LOCATION METHODS
//==============================================================================
    public void addLocation(Location location);
    public void deleteLocation(int id);
    public void updateLocation(Location location);
    public Location getLocationById(int id);
    public List<Location> getAllLocations();
//==============================================================================
//ORGANIZATION METHODS
//==============================================================================
    public void addOrganization(Organization org);
    public void deleteOrganization(int id);
    public void updateOrganization(Organization org);
    public Organization getOrganizationById(int id);
    public List<Organization> getAllOrganizations();
//==============================================================================
//POWER METHODS
//==============================================================================
    public void addPower(Power power);
    public void deletePower(int powerId);
    public void updatePower(Power power);
    public Power getPowerById(int id);
    public List<Power> getAllPowers();
//==============================================================================
//MISC METHODS
//==============================================================================
    public List<Hero> getHerosByLocation(int id);
    public List<Location> getAllHeroLocations(int id);
    public List<Sighting> getSightingsByDate(int id);
    public List<Hero> getAllOrgMembers(int id);
    public List<Organization> getAllHeroOrgs(int id);
    public List<Sighting> getLastTenSightings();
}
