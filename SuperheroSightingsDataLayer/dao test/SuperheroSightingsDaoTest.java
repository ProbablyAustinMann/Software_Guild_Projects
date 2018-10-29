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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author austinmann
 */
public class SuperheroSightingsDaoTest {

    private SuperheroSightingsDao dao;

    public SuperheroSightingsDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext(
                        "test-applicationContext.xml");
        dao = ctx.getBean("superheroSightingsDao", SuperheroSightingsDao.class);

        List<Power> power = dao.getAllPowers();
        power.forEach((currentPower) -> {
            dao.deletePower(currentPower.getPowerId());
        });
        
        List<Sighting> sight = dao.getAllSightings();
        sight.forEach((currentSight) -> {
            dao.deleteSighting(currentSight.getSightingId());
        });

        List<Organization> org = dao.getAllOrganizations();
        org.forEach((currentOrg) -> {
            dao.deleteOrganization(currentOrg.getOrganizationId());
        });

        List<Hero> heros = dao.getAllHeros();
        heros.forEach((currentHero) -> {
            dao.deleteHero(currentHero.getHeroId());
        });

        List<Location> loc = dao.getAllLocations();
        loc.forEach((currentLoc) -> {
            dao.deleteLocation(currentLoc.getLocationId());
        });
    }

    @After
    public void tearDown() {

        List<Power> power = dao.getAllPowers();
        power.forEach((currentPower) -> {
            dao.deletePower(currentPower.getPowerId());
        });
        
        List<Sighting> sight = dao.getAllSightings();
        sight.forEach((currentSight) -> {
            dao.deleteSighting(currentSight.getSightingId());
        });

        List<Organization> org = dao.getAllOrganizations();
        org.forEach((currentOrg) -> {
            dao.deleteOrganization(currentOrg.getOrganizationId());
        });

        List<Hero> heros = dao.getAllHeros();
        heros.forEach((currentHero) -> {
            dao.deleteHero(currentHero.getHeroId());
        });

        List<Location> loc = dao.getAllLocations();
        loc.forEach((currentLoc) -> {
            dao.deleteLocation(currentLoc.getLocationId());
        });

    }

    @Test
    public void addGetDeleteHero() {
        Power power = new Power();
        power.setPowerDescription("Ability to fly");
        dao.addPower(power);
        List<Power> powerList = dao.getAllPowers();
        
        Hero hero = new Hero();
        hero.setHeroName("Batman");
        hero.setHeroDescription("A rich guy who likes cosplay");
        hero.setPower(powerList);
        
        dao.addHero(hero);

        Hero fromDb = dao.getHeroById(hero.getHeroId());
        assertEquals(fromDb, hero);
        
        dao.deletePower(power.getPowerId());
        dao.deleteHero(hero.getHeroId());

        assertNull(dao.getHeroById(hero.getHeroId()));
    }

    @Test
    public void addUpdateHero() {
        Power power = new Power();
        power.setPowerDescription("Ability to fly");
        dao.addPower(power);
        List<Power> powerList = dao.getAllPowers();
        
        Hero hero = new Hero();
        hero.setHeroName("Superman");
        hero.setHeroDescription("Alien who hates green rocks");
        hero.setPower(powerList);
        dao.addHero(hero);

        hero.setHeroDescription("Alien who REALLY REALLY hates green rocks");
        dao.updateHero(hero);

        Hero fromDb = dao.getHeroById(hero.getHeroId());
        assertEquals(hero, fromDb);
    }

    @Test
    public void testGetAllHeros() {
        Power power = new Power();
        power.setPowerDescription("Ability to fly");
        dao.addPower(power);
        List<Power> powerList = dao.getAllPowers();
        
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        dao.addHero(hero1);

        Hero hero2 = new Hero();
        hero2.setHeroName("Hulk");
        hero2.setHeroDescription("Big, green, and pissed");
        hero2.setPower(powerList);
        dao.addHero(hero2);

        List<Hero> heroList = dao.getAllHeros();
        assertEquals(heroList.size(), 2);
    }

    @Test
    public void addGetDeleteSighting() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);
        
        List<Power> powerList = dao.getAllPowers();
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        dao.addHero(hero1);
        List<Hero> heroList = dao.getAllHeros();
        
        Location loc = new Location();
        loc.setLocationName("Central Park");
        loc.setAddress("111 South Street");
        loc.setLatitude(11.11);
        loc.setLongitude(11.11);
        dao.addLocation(loc);

        Sighting sight = new Sighting();
        sight.setLocation(loc);
        sight.setDate(LocalDate.parse("2018-10-09", DateTimeFormatter.ISO_DATE));
        sight.setSightingDescription("Superman flew by");
        sight.setSightingHero(heroList);
        dao.addSighting(sight);

        Sighting fromDb = dao.getSightingById(sight.getSightingId());
        assertEquals(sight, fromDb);
        dao.deleteSighting(sight.getSightingId());

        dao.deleteLocation(loc.getLocationId());

        assertNull(dao.getSightingById(sight.getSightingId()));
    }

    @Test
    public void addUpdateSighting() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);
        
        List<Power> powerList = new ArrayList<>();
        powerList.add(power1);
        
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        
        dao.addHero(hero1);
        
        List<Hero> heroList = new ArrayList<>();
        heroList.add(hero1);
        
        Location loc = new Location();
        loc.setLocationName("Central Park");
        loc.setAddress("111 South Street");
        loc.setLatitude(11.11);
        loc.setLongitude(11.11);
        dao.addLocation(loc);

        Sighting sight = new Sighting();
        sight.setLocation(loc);
        sight.setDate(LocalDate.parse("2018-10-10", DateTimeFormatter.ISO_DATE));
        sight.setSightingDescription("Saw Spiderman fly by");
        sight.setSightingHero(heroList);
        
        dao.addSighting(sight);

        sight.setSightingDescription("Saw Spiderman SWING by");
        
        dao.updateSighting(sight);

        Sighting fromDb = dao.getSightingById(sight.getSightingId());
        assertEquals(sight, fromDb);
    }

    @Test
    public void testGetAllSightings() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);
        
        List<Power> powerList = dao.getAllPowers();
        
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        dao.addHero(hero1);

        Hero hero2 = new Hero();
        hero2.setHeroName("Hulk");
        hero2.setHeroDescription("Big, green, and pissed");
        hero2.setPower(powerList);
        dao.addHero(hero2);
        
        List<Hero> heroList = dao.getAllHeros();
        
        Location loc1 = new Location();
        loc1.setLocationName("Central Park");
        loc1.setAddress("111 South Street");
        loc1.setLatitude(11.11);
        loc1.setLongitude(11.11);
        dao.addLocation(loc1);

        Location loc2 = new Location();
        loc2.setLocationName("Central Park");
        loc2.setAddress("111 South Street");
        loc2.setLatitude(11.11);
        loc2.setLongitude(11.11);
        dao.addLocation(loc2);

        Sighting sight1 = new Sighting();
        sight1.setLocation(loc1);
        sight1.setDate(LocalDate.parse("2018-10-08", DateTimeFormatter.ISO_DATE));
        sight1.setSightingDescription("Heard the Batmobile drive past");
        sight1.setSightingHero(heroList);
        dao.addSighting(sight1);

        Sighting sight2 = new Sighting();
        sight2.setLocation(loc2);
        sight2.setDate(LocalDate.parse("2018-10-07", DateTimeFormatter.ISO_DATE));
        sight2.setSightingDescription("Saw the Joker run by with a bag of money");
        sight2.setSightingHero(heroList);
        dao.addSighting(sight2);

        List<Sighting> sightList = dao.getAllSightings();
        assertEquals(sightList.size(), 2);
    }

    @Test
    public void addGetDeleteOrganization() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);
        
        List<Power> powerList = dao.getAllPowers();
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        dao.addHero(hero1);
        List<Hero> heroList = dao.getAllHeros();
        
        Location loc = new Location();
        loc.setLocationName("Central Park");
        loc.setAddress("111 South Street");
        loc.setLatitude(11.11);
        loc.setLongitude(11.11);
        dao.addLocation(loc);

        Organization org = new Organization();
        org.setOrgName("Justice League");
        org.setLocation(loc);
        org.setEmail("a@a.com");
        org.setPhone("111-111-1111");
        org.setOrgHero(heroList);
        dao.addOrganization(org);

        Organization fromDb = dao.getOrganizationById(org.getOrganizationId());
        assertEquals(org, fromDb);
        dao.deleteOrganization(org.getOrganizationId());

        dao.deleteLocation(loc.getLocationId());

        assertNull(dao.getOrganizationById(org.getOrganizationId()));
    }

    @Test
    public void addUpdateOrganization() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);
        
        List<Power> powerList = dao.getAllPowers();
        
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        dao.addHero(hero1);
        
        List<Hero> heroList = dao.getAllHeros();
        
        Location loc = new Location();
        loc.setLocationName("Central Park");
        loc.setAddress("111 South Street");
        loc.setLatitude(11.11);
        loc.setLongitude(11.11);
        dao.addLocation(loc);

        Organization org = new Organization();
        org.setOrgName("Avengers");
        org.setLocation(loc);
        org.setEmail("b@b.com");
        org.setPhone("111-111-1112");
        org.setOrgHero(heroList);
        dao.addOrganization(org);

        org.setEmail("c@c.com");
        dao.updateOrganization(org);

        Organization fromDb = dao.getOrganizationById(org.getOrganizationId());
        assertEquals(org, fromDb);
    }

    @Test
    public void testGetAllOrganizations() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);
        
        List<Power> powerList = dao.getAllPowers();
        
        Hero hero1 = new Hero();
        hero1.setHeroName("Spiderman");
        hero1.setHeroDescription("Climbs stuff, shoots webs, etc");
        hero1.setPower(powerList);
        dao.addHero(hero1);

        Hero hero2 = new Hero();
        hero2.setHeroName("Hulk");
        hero2.setHeroDescription("Big, green, and pissed");
        hero2.setPower(powerList);
        dao.addHero(hero2);
        
        List<Hero> heroList1 = dao.getAllHeros();
        
        Location loc1 = new Location();
        loc1.setLocationName("Central Park");
        loc1.setAddress("111 South Street");
        loc1.setLatitude(11.11);
        loc1.setLongitude(11.11);
        dao.addLocation(loc1);

        Location loc2 = new Location();
        loc2.setLocationName("Central Park");
        loc2.setAddress("111 South Street");
        loc2.setLatitude(11.11);
        loc2.setLongitude(11.11);
        dao.addLocation(loc2);

        Organization org1 = new Organization();
        org1.setOrgName("Watchmen");
        org1.setLocation(loc1);
        org1.setEmail("d@d.com");
        org1.setPhone("111-111-1113");
        org1.setOrgHero(heroList1);
        dao.addOrganization(org1);

        Organization org2 = new Organization();
        org2.setOrgName("Group of Shady Individuals");
        org2.setLocation(loc2);
        org2.setEmail("e@e.com");
        org2.setPhone("111-111-1114");
        org2.setOrgHero(heroList1);
        dao.addOrganization(org2);

        List<Organization> orgList = dao.getAllOrganizations();
        assertEquals(orgList.size(), 2);
    }

    @Test
    public void addGetDeleteLocation() {
        Location loc = new Location();
        loc.setLocationName("Central Park");
        loc.setAddress("111 South Street");
        loc.setLatitude(11.11);
        loc.setLongitude(11.11);
        dao.addLocation(loc);

        Location fromDb = dao.getLocationById(loc.getLocationId());
        assertEquals(loc, fromDb);
        dao.deleteLocation(loc.getLocationId());

        assertNull(dao.getLocationById(loc.getLocationId()));
    }

    @Test
    public void addUpdateLocation() {
        Location loc = new Location();
        loc.setLocationName("The Bronx");
        loc.setAddress("222 South Street");
        loc.setLatitude(22.11);
        loc.setLongitude(22.11);
        dao.addLocation(loc);

        loc.setAddress("222 North Street");
        dao.updateLocation(loc);

        Location fromDb = dao.getLocationById(loc.getLocationId());
        assertEquals(loc, fromDb);
    }

    @Test
    public void testGetAllLocations() {
        Location loc1 = new Location();
        loc1.setLocationName("Brooklyn");
        loc1.setAddress("333 South Street");
        loc1.setLatitude(33.11);
        loc1.setLongitude(33.11);
        dao.addLocation(loc1);

        Location loc2 = new Location();
        loc2.setLocationName("Long Island");
        loc2.setAddress("444 South Street");
        loc2.setLatitude(44.11);
        loc2.setLongitude(44.11);
        dao.addLocation(loc2);

        List<Location> locList = dao.getAllLocations();
        assertEquals(locList.size(), 2);
    }

    @Test
    public void addGetDeletePower() {
        Power power = new Power();
        power.setPowerDescription("Ability to fly");
        dao.addPower(power);

        Power fromDb = dao.getPowerById(power.getPowerId());
        assertEquals(power, fromDb);
        dao.deletePower(power.getPowerId());

        assertNull(dao.getPowerById(power.getPowerId()));
    }

    @Test
    public void addUpdatePower() {
        Power power = new Power();
        power.setPowerDescription("Moderate Strength");
        dao.addPower(power);

        power.setPowerDescription("SUPER Strength");
        dao.updatePower(power);

        Power fromDb = dao.getPowerById(power.getPowerId());
        assertEquals(power, fromDb);
    }

    @Test
    public void testGetAllPowers() {
        Power power1 = new Power();
        power1.setPowerDescription("Incredible Speed");
        dao.addPower(power1);

        Power power2 = new Power();
        power2.setPowerDescription("Invisibility");
        dao.addPower(power2);

        List<Power> powerList = dao.getAllPowers();
        assertEquals(powerList.size(), 2);
    }

//    @Test
//    public void testGetHerosByLocation() {
//    }
//
//    @Test
//    public void testGetAllHeroLocations() {
//    }
//
//    @Test
//    public void testGetSightingsByDate() {
//    }
//
//    @Test
//    public void testGetAllOrgMembers() {
//    }
//
//    @Test
//    public void testGetAllHeroOrgs() {
//    }
}
