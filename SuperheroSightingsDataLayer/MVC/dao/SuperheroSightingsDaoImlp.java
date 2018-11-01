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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author austinmann
 */
public class SuperheroSightingsDaoImlp implements SuperheroSightingsDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //SQL STATEMENTS
    //==========================================================================
    //HERO SQL
    //========
    public static final String SQL_INSERT_HERO
            = "insert into Hero (HeroName, HeroDescription) values (?, ?)";

    public static final String SQL_DELETE_HERO
            = "delete from Hero where HeroId = ?";

    public static final String SQL_UPDATE_HERO
            = "update Hero set HeroName = ?, HeroDescription = ? where HeroId = ?";

    public static final String SQL_SELECT_HERO
            = "select * from Hero where HeroId = ?";

    public static final String SQL_SELECT_ALL_HEROS
            = "select * from Hero";

    //SIGHTING SQL
    //============
    public static final String SQL_INSERT_SIGHTING
            = "insert into Sighting (LocationId, SightingDate, SightingDescription) values (?, ?, ?)";

    public static final String SQL_DELETE_SIGHTING
            = "delete from Sighting where SightingId = ?";

    public static final String SQL_UPDATE_SIGHTING
            = "update Sighting set LocationId = ?, SightingDate = ?, SightingDescription = ? where SightingId = ?";

    public static final String SQL_SELECT_SIGHTING
            = "SELECT * "
            + "FROM Location  "
            + "INNER JOIN Sighting ON Location.LocationId = Sighting.LocationId "
            + "WHERE SightingId = ?";

    public static final String SQL_SELECT_ALL_SIGHTINGS
            = "SELECT * "
            + "FROM Location  "
            + "INNER JOIN Sighting ON Location.LocationId = Sighting.LocationId ";

    public static final String SQL_REMOVE_LOCATION_FROM_SIGHTING
            = "update Sighting set LocationId = NULL where LocationId = ?";

    //LOCATION SQL
    //============
    public static final String SQL_INSERT_LOCATION
            = "insert into Location(LocationName, Address, Latitude, Longitude) values(?, ?, ?, ?)";

    public static final String SQL_DELETE_LOCATION
            = "delete from Location where LocationId = ?";

    public static final String SQL_UPDATE_LOCATION
            = "update Location set LocationName = ?, Address = ?, Latitude = ?, Longitude = ? where LocationId = ?";

    public static final String SQL_SELECT_LOCATION
            = "select * from Location where LocationId = ?";

    public static final String SQL_SELECT_ALL_LOCATIONS
            = "select * from Location";

    //ORGANIZATION SQL
    //================
    public static final String SQL_INSERT_ORGANIZATION
            = "insert into Organization (OrgName, LocationId, Phone, Email) values (?, ?, ?, ?)";

    public static final String SQL_DELETE_ORGANIZATION
            = "delete from Organization where OrganizationId = ?";

    public static final String SQL_UPDATE_ORGANIZATION
            = "update Organization set OrgName = ?, LocationId = ?, Phone = ?, Email = ? where OrganizationId = ?";

    public static final String SQL_SELECT_ORGANIZATION
            = "SELECT * "
            + "FROM Location  "
            + "INNER JOIN Organization ON Location.LocationId = Organization.LocationId "
            + "WHERE OrganizationId = ?";

    public static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "SELECT * "
            + "FROM Location  "
            + "INNER JOIN Organization ON Location.LocationId = Organization.LocationId ";

    public static final String SQL_REMOVE_LOCATION_FROM_ORG
            = "update Organization set LocationId = NULL where LocationId = ?";

    //SUPERPOWER SQL
    //=========
    public static final String SQL_INSERT_POWER
            = "insert into Superpower (PowerDescription) values(?)";

    public static final String SQL_DELETE_POWER
            = "delete from Superpower where PowerId = ?";

    public static final String SQL_UPDATE_POWER
            = "update Superpower set PowerDescription = ? where PowerId = ?";

    public static final String SQL_SELECT_POWER
            = "select * from Superpower where PowerId = ?";

    public static final String SQL_SELECT_ALL_POWERS
            = "select * from Superpower";

    //BRIDGE SQL
    //==========
    public static final String SQL_INSERT_HERO_ORGS
            = "insert into HeroOrganization(HeroId, OrganizationId) values (?, ?)";

    public static final String SQL_INSERT_HERO_POWER
            = "insert into HeroPower(HeroId, PowerId) values (?, ?)";

    public static final String SQL_INSERT_HERO_SIGHTING
            = "insert into HeroSighting(HeroId, SightingId) values (?, ?)";

    public static final String SQL_DELETE_HERO_ORGS
            = "delete from HeroOrganization where HeroId = ?";

    public static final String SQL_DELETE_ORG_HEROES
            = "delete from HeroOrganization where OrganizationId = ?";

    public static final String SQL_DELETE_HERO_POWER
            = "delete from HeroPower where HeroId = ?";

    public static final String SQL_DELETE_POWER_HERO
            = "delete from HeroPower where PowerId = ?";

    public static final String SQL_DELETE_HERO_SIGHTING
            = "delete from HeroSighting where HeroId = ?";

    public static final String SQL_DELETE_SIGHTING_HERO
            = "delete from HeroSighting where SightingId = ?";

    //MISCELLANEOUS SQL
    //========
    public static final String SQL_SELECT_HEROS_BY_LOCATION
            = "SELECT HeroName "
            + "FROM Hero "
            + "INNER JOIN HeroSighting ON Hero.HeroId = HeroSighting.HeroId "
            + "INNER JOIN Sighting ON HeroSighting.SightingId = Sighting.SightingId "
            + "INNER JOIN Location ON Sighting.LocationId = Location.LocationId "
            + "WHERE Location.LocationName = ?";

    public static final String SQL_SELECT_ALL_HEROS_LOCATIONS
            = "SELECT LocationName "
            + "FROM Location "
            + "INNER JOIN Sighting ON Sighting.LocationId = Location.LocationId "
            + "INNER JOIN HeroSighting ON HeroSighting.SightingId = Sighting.SightingId "
            + "INNER JOIN Hero ON Hero.HeroId = HeroSighting.HeroId "
            + "WHERE Hero.HeroName = ?";

    public static final String SQL_GET_HERO_AND_LOCATION_BY_DATE
            = "SELECT HeroName, LocationName "
            + "FROM Hero "
            + "INNER JOIN HeroSighting ON Hero.HeroId = HeroSighting.HeroId "
            + "INNER JOIN Sighting ON HeroSighting.SightingId = Sighting.SightingId "
            + "INNER JOIN Location ON Sighting.LocationId = Location.LocationId "
            + "WHERE SightingDate = ?";

    public static final String SQL_GET_ALL_ORG_MEMBERS
            = "SELECT * "
            + "FROM Hero "
            + "INNER JOIN HeroOrganization ON HeroOrganization.HeroId = Hero.HeroId "
            + "INNER JOIN Organization ON Organization.OrganizationId = HeroOrganization.OrganizationId "
            + "WHERE Organization.OrganizationId = ?";

    public static final String SQL_GET_ALL_HERO_ORGS
            = "SELECT OrgName "
            + "FROM Organization "
            + "INNER JOIN HeroOrganization ON Organization.OrganizationId = HeroOrganization.OrganizationId "
            + "INNER JOIN Hero ON HeroOrganization.HeroId = Hero.HeroId "
            + "WHERE Hero.HeroName = ?";

    public static final String SQL_GET_POWERS_FOR_HERO
            = "SELECT * "
            + "FROM Superpower  "
            + "INNER JOIN HeroPower ON Superpower.PowerId = HeroPower.PowerId "
            + "INNER JOIN Hero ON HeroPower.HeroId = Hero.HeroId "
            + "WHERE HeroPower.HeroId = ?";

    public static final String SQL_GET_HEROES_FOR_SIGHTING
            = "SELECT * "
            + "FROM Hero "
            + "INNER JOIN HeroSighting ON HeroSighting.HeroId = Hero.HeroId "
            + "INNER JOIN Sighting ON Sighting.SightingId = HeroSighting.SightingId "
            + "WHERE Sighting.SightingId = ?";

    public static final String SQL_GET_LOCATION_FOR_ORG
            = "SELECT * "
            + "FROM Location "
            + "INNER JOIN Organization ON Organization.LocationId = Location.LocationId "
            + "WHERE Organization.OrganizationId = ?";

    public static final String SQL_GET_LOACTION_FOR_SIGHTING
            = "SELECT * "
            + "FROM Location "
            + "INNER JOIN Sighting ON Sighting.LocationId = Location.LocationId "
            + "WHERE Sighting.SightingId = ?";

    public static final String SQL_GET_SIGHTING_FOR_LOCATION
            = "select * from Sighting where LocationId = ?";

    public static final String SQL_GET_SIGHTING_FOR_HEROES
            = "select * from Sighting where HeroId = ?";

    public static final String SQL_GET_LAST_TEN_ENTRIES
            = "SELECT * "
            + "FROM Sighting "
            + "INNER JOIN Location ON Location.LocationId = Sighting.LocationId "
            + "ORDER BY SightingDate DESC "
            + "LIMIT 10";

    //DAO IMPL MTEHODS
    //==========================================================================
    //HERO METHODS
    //============
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHero(Hero hero) {
        jdbcTemplate.update(SQL_INSERT_HERO,
                hero.getHeroName(),
                hero.getHeroDescription());

        hero.setHeroId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));

        hero.getPower();
        insertHeroPower(hero);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteHero(int id) {
        jdbcTemplate.update(SQL_DELETE_HERO_POWER, id);
        jdbcTemplate.update(SQL_DELETE_HERO_ORGS, id);
        jdbcTemplate.update(SQL_DELETE_HERO_SIGHTING, id);
        jdbcTemplate.update(SQL_DELETE_HERO, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateHero(Hero hero) {
        jdbcTemplate.update(SQL_UPDATE_HERO,
                hero.getHeroName(),
                hero.getHeroDescription(),
                hero.getHeroId());
        hero.getPower();

        jdbcTemplate.update(SQL_DELETE_HERO_POWER,
                hero.getHeroId());
        insertHeroPower(hero);
    }

    @Override
    public Hero getHeroById(int id) {
        try {
            Hero hero = jdbcTemplate.queryForObject(SQL_SELECT_HERO,
                    new HeroMapper(),
                    id);
            hero.setPower(getPowersForHero(hero));
            return hero;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Hero> getAllHeros() {
        try {
            List<Hero> heroList = jdbcTemplate.query(SQL_SELECT_ALL_HEROS,
                    new HeroMapper());
            for (Hero hero : heroList) {
                hero.setPower(getPowersForHero(hero));
            }
            return heroList;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //SIGHTING METHODS
    //================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
                sighting.getLocation().getLocationId(),
                sighting.getDate().toString(),
                sighting.getSightingDescription());

        sighting.setSightingId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));

        sighting.getSightingHero();
        insertHeroSighting(sighting);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING_HERO, sightingId);
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sighting.getLocation().getLocationId(),
                sighting.getDate().toString(),
                sighting.getSightingDescription(),
                sighting.getSightingId());
        sighting.getSightingHero();

        jdbcTemplate.update(SQL_DELETE_SIGHTING_HERO,
                sighting.getSightingId());
        insertHeroSighting(sighting);
    }

    @Override
    public Sighting getSightingById(int id) {
        try {
            Sighting sight = jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING,
                    new SightingMapper(),
                    id);
            sight.setSightingHero(getHeroesForSighting(sight));
            sight.setLocation(getLocationForSighting(sight));
            return sight;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Sighting> getAllSightings() {
        try {
            return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS,
                    new SightingMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //LOCATION METHODS
    //================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getLocationName(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude());

        int locationId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        location.setLocationId(locationId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteLocation(int id) {
        jdbcTemplate.update(SQL_REMOVE_LOCATION_FROM_ORG, id);
        jdbcTemplate.update(SQL_REMOVE_LOCATION_FROM_SIGHTING, id);
        jdbcTemplate.update(SQL_DELETE_LOCATION, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getAddress(),
                location.getLatitude(),
                location.getLongitude(),
                location.getLocationId());
    }

    @Override
    public Location getLocationById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_LOCATION,
                    new LocationMapper(),
                    id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Location> getAllLocations() {
        try {
            return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS,
                    new LocationMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //ORGANIZATION METHODS
    //====================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization org) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATION,
                org.getOrgName(),
                org.getLocation().getLocationId(),
                org.getPhone(),
                org.getEmail());

        org.setOrganizationId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class));

        org.getOrgHero();
        insertHeroOrgs(org);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteOrganization(int id) {
        jdbcTemplate.update(SQL_DELETE_ORG_HEROES, id);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATION, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateOrganization(Organization org) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATION,
                org.getOrgName(),
                org.getLocation().getLocationId(),
                org.getPhone(),
                org.getEmail(),
                org.getOrganizationId());
        org.getOrgHero();

        jdbcTemplate.update(SQL_DELETE_ORG_HEROES,
                org.getOrganizationId());
        insertHeroOrgs(org);
    }

    @Override
    public Organization getOrganizationById(int id) {
        try {
            Organization org = jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATION,
                    new OrganizationMapper(),
                    id);
            org.setOrgHero(getHeroesForOrg(org));
            org.setLocation(getLocationForOrg(org));
            return org;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Organization> getAllOrganizations() {
        try {
            return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS,
                    new OrganizationMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //SUPERPOWER METHODS
    //=============
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPower(Power power) {
        jdbcTemplate.update(SQL_INSERT_POWER,
                power.getPowerDescription());

        int powerId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        power.setPowerId(powerId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deletePower(int powerId) {
        jdbcTemplate.update(SQL_DELETE_POWER_HERO, powerId);
        jdbcTemplate.update(SQL_DELETE_POWER, powerId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updatePower(Power power) {
        jdbcTemplate.update(SQL_UPDATE_POWER,
                power.getPowerDescription(),
                power.getPowerId());
    }

    @Override
    public Power getPowerById(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_POWER,
                    new PowerMapper(),
                    id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Power> getAllPowers() {
        try {
            return jdbcTemplate.query(SQL_SELECT_ALL_POWERS,
                    new PowerMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //MISCELLANEOUS METHODS
    //=====================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Hero> getHerosByLocation(int id) {
        try {
            List<Hero> heroList = jdbcTemplate.query(SQL_SELECT_HEROS_BY_LOCATION,
                    new HeroMapper(),
                    id);
            for (Hero h : heroList) {
                List<Sighting> sightingList = getSightingForHeroes(h);
                for (Sighting s : sightingList) {
                    getLocationForSighting(s);
                }
            }
            return heroList;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Location> getAllHeroLocations(int id) {
        try {
            List<Location> locList = jdbcTemplate.query(SQL_SELECT_ALL_HEROS_LOCATIONS,
                    new LocationMapper(),
                    id);
            for (Location loc : locList) {
                List<Sighting> sight = getSightingForLocation(loc);
                for (Sighting s : sight) {
                    getHeroesForSighting(s);
                }
            }
            return locList;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Sighting> getSightingsByDate(int id) {
        try {
            return jdbcTemplate.query(SQL_GET_HERO_AND_LOCATION_BY_DATE,
                    new SightingMapper(),
                    id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Hero> getAllOrgMembers(int id) {
        try {
            List<Hero> heroList = jdbcTemplate.query(SQL_GET_ALL_ORG_MEMBERS,
                    new HeroMapper(),
                    id);
            for (Hero h : heroList) {
                List<Power> powerList = new ArrayList<>();
                powerList = getPowersForHero(h);
                h.setPower(powerList);
            }
            return heroList;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Organization> getAllHeroOrgs(int id) {
        try {
            List<Organization> orgList = jdbcTemplate.query(SQL_GET_ALL_HERO_ORGS,
                    new OrganizationMapper(),
                    id);
            for (Organization org : orgList) {
                List<Hero> heroList = new ArrayList<>();
                heroList = getHeroesForOrg(org);
                org.setOrgHero(heroList);
            }
            return orgList;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    //HELPER METHODS
    //==========================================================================
    private void insertHeroOrgs(Organization org) {
        final int orgId = org.getOrganizationId();
        final List<Hero> heroList = org.getOrgHero();

        for (Hero currentHero : heroList) {
            jdbcTemplate.update(SQL_INSERT_HERO_ORGS,
                    currentHero.getHeroId(),
                    orgId);
        }

    }

    private void insertHeroPower(Hero hero) {
        final int heroId = hero.getHeroId();
        final List<Power> powerList = hero.getPower();

        for (Power currentPower : powerList) {
            jdbcTemplate.update(SQL_INSERT_HERO_POWER,
                    heroId,
                    currentPower.getPowerId());
        }
    }

    private void insertHeroSighting(Sighting sight) {
        final int sightId = sight.getSightingId();
        final List<Hero> heroList = sight.getSightingHero();

        for (Hero currentHero : heroList) {
            jdbcTemplate.update(SQL_INSERT_HERO_SIGHTING,
                    currentHero.getHeroId(),
                    sightId);
        }
    }

    private List<Power> getPowersForHero(Hero hero) {
        return jdbcTemplate.query(SQL_GET_POWERS_FOR_HERO,
                new PowerMapper(),
                hero.getHeroId());
    }

    private List<Hero> getHeroesForOrg(Organization org) {
        List<Hero> heroList = jdbcTemplate.query(SQL_GET_ALL_ORG_MEMBERS,
                new HeroMapper(),
                org.getOrganizationId());
        for (Hero h : heroList) {
            List<Power> powerList = getPowersForHero(h);
            h.setPower(powerList);
        }
        return heroList;
    }

    private List<Hero> getHeroesForSighting(Sighting sight) {
        List<Hero> heroList = jdbcTemplate.query(SQL_GET_HEROES_FOR_SIGHTING,
                new HeroMapper(),
                sight.getSightingId());
        for (Hero h : heroList) {
            List<Power> powerList = getPowersForHero(h);
            h.setPower(powerList);
        }
        return heroList;
    }

    private Location getLocationForOrg(Organization org) {
        return jdbcTemplate.queryForObject(SQL_GET_LOCATION_FOR_ORG,
                new LocationMapper(),
                org.getOrganizationId());
    }

    private Location getLocationForSighting(Sighting sight) {
        return jdbcTemplate.queryForObject(SQL_GET_LOACTION_FOR_SIGHTING,
                new LocationMapper(),
                sight.getSightingId());
    }

    private List<Organization> getOrgsForHero(Hero hero) {
        return jdbcTemplate.query(SQL_GET_ALL_HERO_ORGS,
                new OrganizationMapper(),
                hero.getHeroId());
    }

    private List<Sighting> getSightingForLocation(Location loc) {
        return jdbcTemplate.query(SQL_GET_SIGHTING_FOR_LOCATION,
                new SightingMapper(),
                loc.getLocationId());
    }

    private List<Sighting> getSightingForHeroes(Hero hero) {
        return jdbcTemplate.query(SQL_GET_SIGHTING_FOR_HEROES,
                new SightingMapper(),
                hero.getHeroId());
    }

    @Override
    public List<Sighting> getLastTenSightings() {
        try {
            return jdbcTemplate.query(SQL_GET_LAST_TEN_ENTRIES,
                    new SightingMapper());
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    // MAPPERS
    // =========================================================================
    private static final class HeroMapper implements RowMapper<Hero> {

        @Override
        public Hero mapRow(ResultSet rs, int i) throws SQLException {
            Hero hero = new Hero();
            hero.setHeroId(rs.getInt("HeroId"));
            hero.setHeroName(rs.getString("HeroName"));
            hero.setHeroDescription(rs.getString("HeroDescription"));

            return hero;
        }
    }

    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("LocationId"));
            location.setLocationName(rs.getString("LocationName"));
            location.setAddress(rs.getString("Address"));
            location.setLatitude(rs.getDouble("Latitude"));
            location.setLongitude(rs.getDouble("Longitude"));

            Sighting sighting = new Sighting();
            sighting.setSightingId(rs.getInt("SightingId"));
            sighting.setDate(rs.getTimestamp("SightingDate").toLocalDateTime().toLocalDate());
            sighting.setSightingDescription(rs.getString("SightingDescription"));
            sighting.setLocation(location);

            return sighting;
        }
    }

    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("LocationId"));
            location.setLocationName(rs.getString("LocationName"));
            location.setAddress(rs.getString("Address"));
            location.setLatitude(rs.getDouble("Latitude"));
            location.setLongitude(rs.getDouble("Longitude"));

            return location;
        }
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("LocationId"));
            location.setLocationName(rs.getString("LocationName"));
            location.setAddress(rs.getString("Address"));
            location.setLatitude(rs.getDouble("Latitude"));
            location.setLongitude(rs.getDouble("Longitude"));

            Organization org = new Organization();
            org.setOrganizationId(rs.getInt("OrganizationId"));
            org.setOrgName(rs.getString("OrgName"));
            org.setPhone(rs.getString("Phone"));
            org.setEmail(rs.getString("Email"));
            org.setLocation(location);

            return org;
        }
    }

    private static final class PowerMapper implements RowMapper<Power> {

        @Override
        public Power mapRow(ResultSet rs, int i) throws SQLException {
            Power power = new Power();
            power.setPowerId(rs.getInt("PowerId"));
            power.setPowerDescription(rs.getString("PowerDescription"));

            return power;
        }
    }
}
