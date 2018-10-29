/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.controller;

import com.sg.superherosightings.dao.SuperheroSightingsDao;
import com.sg.superherosightings.model.Hero;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Power;
import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author austinmann
 */
@Controller
public class SuperheroSightingsController {

    SuperheroSightingsDao dao;

    @Inject
    public SuperheroSightingsController(SuperheroSightingsDao dao) {
        this.dao = dao;
    }
//==============================================================================
//VIEW ALL OBJECT METHODS
//==============================================================================

    @RequestMapping(value = "/viewheroes", method = RequestMethod.GET)
    public String displayHeroes(Map<String, Object> model) {
        //add powers to model for 'add hero' section
        List<Power> powerList = dao.getAllPowers();
        model.put("powerList", powerList);
        //add heroes to model
        List<Hero> heroList = dao.getAllHeros();
        model.put("heroList", heroList);
        return "heroes";
    }

    @RequestMapping(value = "/viewlocations", method = RequestMethod.GET)
    public String displayLocations(Map<String, Object> model) {
        //add locations to model
        List<Location> locationList = dao.getAllLocations();
        model.put("locationList", locationList);
        return "locations";
    }

    @RequestMapping(value = "/vieworgs", method = RequestMethod.GET)
    public String displayOrgs(Map<String, Object> model) {
        //add heroes to model for 'add organization' section
        List<Hero> heroList = dao.getAllHeros();
        model.put("heroList", heroList);
        //add locations to model for 'add organization' section
        List<Location> locationList = dao.getAllLocations();
        model.put("locationList", locationList);
        //add organizations to model
        List<Organization> orgList = dao.getAllOrganizations();
        model.put("orgList", orgList);
        return "organizations";
    }

    @RequestMapping(value = "/viewpowers", method = RequestMethod.GET)
    public String displayPowers(Map<String, Object> model) {
        //add powers to model
        List<Power> powerList = dao.getAllPowers();
        model.put("powerList", powerList);
        return "powers";
    }

    @RequestMapping(value = "/viewsightings", method = RequestMethod.GET)
    public String displaySightings(Map<String, Object> model) {
        //add heroes to model for 'add organization' section
        List<Hero> heroList = dao.getAllHeros();
        model.put("heroList", heroList);
        //add locations to model for 'add organization' section
        List<Location> locationList = dao.getAllLocations();
        model.put("locationList", locationList);
        //add sightings to model
        List<Sighting> sightingList = dao.getAllSightings();
        model.put("sightingList", sightingList);
        return "sightings";
    }
//==============================================================================
//VIEW OBJECT INFO METHODS
//==============================================================================

    @RequestMapping(value = "/viewheroinfo", method = RequestMethod.GET)
    public String displayHeroInfo(HttpServletRequest request, Model model) {
        //get id string
        String heroIdParameter = request.getParameter("heroId");
        //convert to an integer
        int heroId = Integer.parseInt(heroIdParameter);
        //get hero with the id integer
        Hero heroInfo = dao.getHeroById(heroId);
        //add hero info to the model
        model.addAttribute("heroInfo", heroInfo);
        return "heroInfo";
    }

    @RequestMapping(value = "/viewlocationinfo", method = RequestMethod.GET)
    public String displayLocationInfo(HttpServletRequest request, Model model) {
        //get id string
        String locationIdParameter = request.getParameter("locationId");
        //convert to an integer
        int locationId = Integer.parseInt(locationIdParameter);
        //get location with the id integer
        Location locationInfo = dao.getLocationById(locationId);
        //add location info to the model
        model.addAttribute("locationInfo", locationInfo);
        return "locationInfo";
    }

    @RequestMapping(value = "/vieworginfo", method = RequestMethod.GET)
    public String displayOrgInfo(HttpServletRequest request, Model model) {
        //get id string
        String orgIdParameter = request.getParameter("organizationId");
        //convert to an integer
        int orgId = Integer.parseInt(orgIdParameter);
        //get organization with the id integer
        Organization orgInfo = dao.getOrganizationById(orgId);
        //add organization info to the model
        model.addAttribute("orgInfo", orgInfo);
        return "orgInfo";
    }

    @RequestMapping(value = "/viewpowerinfo", method = RequestMethod.GET)
    public String displayPowerInfo(HttpServletRequest request, Model model) {
        //get id string
        String powerIdParameter = request.getParameter("powerId");
        //convert to an integer
        int powerId = Integer.parseInt(powerIdParameter);
        //get power with the id integer
        Power powerInfo = dao.getPowerById(powerId);
        //add power info to the model
        model.addAttribute("powerInfo", powerInfo);
        return "powerInfo";
    }

    @RequestMapping(value = "/viewsightinginfo", method = RequestMethod.GET)
    public String displaySightingInfo(HttpServletRequest request, Model model) {
        //get id string
        String sightingIdParameter = request.getParameter("sightingId");
        //convert to an integer
        int sightingId = Integer.parseInt(sightingIdParameter);
        //get sighting with the id integer
        Sighting sightingInfo = dao.getSightingById(sightingId);
        //add sighting info to the model
        model.addAttribute("sightingInfo", sightingInfo);
        return "sightingInfo";
    }
//==============================================================================
//DELETE OBJECT METHODS
//==============================================================================

    @RequestMapping(value = "/deletehero", method = RequestMethod.GET)
    public String deleteHero(HttpServletRequest request) {
        //get id string
        String heroIdParameter = request.getParameter("heroId");
        //convert to an integer
        int heroId = Integer.parseInt(heroIdParameter);
        //use id to delete hero
        dao.deleteHero(heroId);
        return "redirect:viewheroes";
    }

    @RequestMapping(value = "/deletelocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        //get id string
        String locationIdParameter = request.getParameter("locationId");
        //convert to an integer
        int locationId = Integer.parseInt(locationIdParameter);
        //use id to delete location
        dao.deleteLocation(locationId);
        return "redirect:viewlocations";
    }

    @RequestMapping(value = "/deleteorg", method = RequestMethod.GET)
    public String deleteOrg(HttpServletRequest request) {
        //get id string
        String orgIdParameter = request.getParameter("organizationId");
        //convert to an integer
        int orgId = Integer.parseInt(orgIdParameter);
        //use id to delete organization
        dao.deleteOrganization(orgId);
        return "redirect:vieworgs";
    }

    @RequestMapping(value = "/deletepower", method = RequestMethod.GET)
    public String deletePower(HttpServletRequest request) {
        //get id string
        String powerIdParameter = request.getParameter("powerId");
        //convert to an integer
        int powerId = Integer.parseInt(powerIdParameter);
        //use id to delete power
        dao.deletePower(powerId);
        return "redirect:viewpowers";
    }

    @RequestMapping(value = "/deletesighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        //get id string
        String sightingIdParameter = request.getParameter("sightingId");
        //convert to an integer
        int sightingId = Integer.parseInt(sightingIdParameter);
        //use id to delete sighting
        dao.deleteSighting(sightingId);
        return "redirect:viewsightings";
    }
//==============================================================================
//CREATE OBJECT METHODS
//==============================================================================

    @RequestMapping(value = "/addhero", method = RequestMethod.POST)
    public String createHero(HttpServletRequest request) {
        //create new hero
        Hero hero = new Hero();
        try {
            //set attributes
            hero.setHeroName(request.getParameter("heroName"));
            hero.setHeroDescription(request.getParameter("heroDescription"));
            //get power ids in string form
            String[] selectedPowers = request.getParameterValues("powerList");
            List<Power> powerList = new ArrayList<>();
            //convert id strings to integers and use them to get power objects...
            for (String powerString : selectedPowers) {
                int powerInt = Integer.parseInt(powerString);
                Power pow = dao.getPowerById(powerInt);
                powerList.add(pow);
            }
            //...and add the list created into the hero object
            hero.setPower(powerList);
        } catch (NullPointerException ex) {
            return "redirect:viewheroes";
        }
        dao.addHero(hero);
        return "redirect:viewheroes";
    }

    @RequestMapping(value = "/addlocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) {
        //create new location
        Location loc = new Location();
        //set attributes
        loc.setLocationName(request.getParameter("locationName"));
        loc.setAddress(request.getParameter("address"));
        //try/catch to prevent junk data from causing a number format exception
        try {
            String lat = (request.getParameter("latitude"));
            double doubleLat = Double.parseDouble(lat);
            loc.setLatitude(doubleLat);
            String lon = request.getParameter("longitude");
            double doubleLon = Double.parseDouble(lon);
            loc.setLongitude(doubleLon);
        } catch (NumberFormatException | NullPointerException ex) {
            return "redirect:viewlocations";
        }
        dao.addLocation(loc);
        return "redirect:viewlocations";
    }

    @RequestMapping(value = "/addorg", method = RequestMethod.POST)
    public String createOrg(HttpServletRequest request) {
        //create new organization
        Organization org = new Organization();
        try {
            //set attributes
            org.setOrgName(request.getParameter("orgName"));
            String location = request.getParameter("location");
            int locationInt = Integer.parseInt(location);
            Location orgLoc = dao.getLocationById(locationInt);
            org.setLocation(orgLoc);
            org.setPhone(request.getParameter("phone"));
            org.setEmail(request.getParameter("email"));
            //get hero ids in string form
            String[] selectedHeroes = request.getParameterValues("orgHero");
            List<Hero> heroList = new ArrayList<>();
            //convert id strings to integers and use them to get hero objects...
            for (String heroString : selectedHeroes) {
                int heroInt = Integer.parseInt(heroString);
                Hero hero = dao.getHeroById(heroInt);
                //...and add the list created into the organization object
                heroList.add(hero);
            }
            org.setOrgHero(heroList);
        } catch (NumberFormatException | NullPointerException ex) {
            return "redirect:vieworgs";
        }
        dao.addOrganization(org);
        return "redirect:vieworgs";
    }

    @RequestMapping(value = "/addpower", method = RequestMethod.POST)
    public String createPower(HttpServletRequest request) {
        //create new power
        Power power = new Power();
        //set attributes
        power.setPowerDescription(request.getParameter("powerDescription"));
        dao.addPower(power);
        return "redirect:viewpowers";
    }

    @RequestMapping(value = "/addsighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) {
        //create new sighting
        Sighting sight = new Sighting();
        try {
            //set attributes
            String location = request.getParameter("location");
            int locationInt = Integer.parseInt(location);
            Location sightLoc = dao.getLocationById(locationInt);
            sight.setLocation(sightLoc);
            String date = request.getParameter("date");
            LocalDate localDate = LocalDate.parse(date);
            sight.setDate(localDate);
            sight.setSightingDescription(request.getParameter("sightingDescription"));
            //get hero ids in string form
            String[] selectedHeroes = request.getParameterValues("sightingHero");
            List<Hero> heroList = new ArrayList<>();
            //convert id strings to integers and use them to get hero objects...
            for (String heroString : selectedHeroes) {
                int heroInt = Integer.parseInt(heroString);
                Hero hero = dao.getHeroById(heroInt);
                //...and add the list created into the sighting object
                heroList.add(hero);
            }
            sight.setSightingHero(heroList);
        } catch (NumberFormatException | DateTimeParseException | NullPointerException ex) {
            return "redirect:viewsightings";
        }
        dao.addSighting(sight);
        return "redirect:viewsightings";
    }
//==============================================================================
//DISPLAY EDIT PAGE METHODS
//==============================================================================

    @RequestMapping(value = "/heroedit", method = RequestMethod.GET)
    public String displayEditHeroPage(HttpServletRequest request, Model model) {
        //get id as string for hero to edit
        String heroIdParameter = request.getParameter("heroId");
        //add powers to model for 'edit hero' section
        List<Power> powerList = dao.getAllPowers();
        model.addAttribute("powerList", powerList);
        //parse string to integer
        int heroId = Integer.parseInt(heroIdParameter);
        //get hero to edit
        Hero heroedit = dao.getHeroById(heroId);
        //add to model
        model.addAttribute("heroedit", heroedit);
        return "heroedit";
    }

    @RequestMapping(value = "/locationedit", method = RequestMethod.GET)
    public String displayEditLocationPage(HttpServletRequest request, Model model) {
        //get id as string for location to edit
        String locationIdParameter = request.getParameter("locationId");
        //parse string to integer
        int locationId = Integer.parseInt(locationIdParameter);
        //get location to edit
        Location locationedit = dao.getLocationById(locationId);
        //add to model
        model.addAttribute("locationedit", locationedit);
        return "locationedit";
    }

    @RequestMapping(value = "/orgedit", method = RequestMethod.GET)
    public String displayEditOrgPage(HttpServletRequest request, Model model) {
        //get id as string for organization to edit
        String orgIdParameter = request.getParameter("organizationId");
        //add heroes to model for 'edit organization' section
        List<Hero> heroList = dao.getAllHeros();
        model.addAttribute("heroList", heroList);
        //add locations to model for 'edit organization' section
        List<Location> locationList = dao.getAllLocations();
        model.addAttribute("locationList", locationList);
        //parse string to integer
        int orgId = Integer.parseInt(orgIdParameter);
        //get organization to edit
        Organization orgedit = dao.getOrganizationById(orgId);
        //add to model
        model.addAttribute("orgedit", orgedit);
        return "orgedit";
    }

    @RequestMapping(value = "/poweredit", method = RequestMethod.GET)
    public String displayEditPowerPage(HttpServletRequest request, Model model) {
        //get id as string for power to edit
        String powerIdParameter = request.getParameter("powerId");
        //parse string to integer 
        int powerId = Integer.parseInt(powerIdParameter);
        //get power to edit
        Power poweredit = dao.getPowerById(powerId);
        //add to model
        model.addAttribute("poweredit", poweredit);
        return "poweredit";
    }

    @RequestMapping(value = "/sightingedit", method = RequestMethod.GET)
    public String displayEditSightingPage(HttpServletRequest request, Model model) {
        //get id as string for sighting to edit
        String sightingIdParameter = request.getParameter("sightingId");
        //add heroes to model for 'edit sighting' section
        List<Hero> heroList = dao.getAllHeros();
        model.addAttribute("heroList", heroList);
        //add locations to model for 'edit sightings' section
        List<Location> locationList = dao.getAllLocations();
        model.addAttribute("locationList", locationList);
        //parse string to integer
        int sightingId = Integer.parseInt(sightingIdParameter);
        //get sighting to edit
        Sighting sightingedit = dao.getSightingById(sightingId);
        //add to model
        model.addAttribute("sightingedit", sightingedit);
        return "sightingedit";
    }
//==============================================================================
//EDIT OBJECT METHODS
//==============================================================================

    @RequestMapping(value = "/edithero", method = RequestMethod.POST)
    public String editHero(HttpServletRequest request) {
        //create new hero
        Hero newHero = new Hero();
        //get the id of the hero to be edited...
        String heroIdParameter = request.getParameter("heroId");
        int heroId = Integer.parseInt(heroIdParameter);
        //...and set that id to the new hero
        newHero.setHeroId(heroId);
        //then use that id to get the old hero
        Hero oldHero = dao.getHeroById(heroId);
        //if the field has new data, pass that data into the new hero object...
        //...if not, use the old hero to pass the old data into the new hero
        String name = request.getParameter("heroName");
        if (name.length() > 0) {
            newHero.setHeroName(name);
        } else {
            newHero.setHeroName(oldHero.getHeroName());
        }
        String desc = request.getParameter("heroDescription");
        if (desc.length() > 0) {
            newHero.setHeroDescription(desc);
        } else {
            newHero.setHeroDescription(oldHero.getHeroDescription());
        }
        String[] selectedPowers = request.getParameterValues("powerList");

        if (selectedPowers != null) {
            List<Power> powerList = new ArrayList<>();
            for (String powerString : selectedPowers) {
                int powerInt = Integer.parseInt(powerString);
                Power pow = dao.getPowerById(powerInt);
                powerList.add(pow);
            }
            newHero.setPower(powerList);
        } else {
            newHero.setPower(oldHero.getPower());
        }
        //last, delete the old hero...
        dao.addHero(newHero);
        //...and add the new one
        dao.deleteHero(oldHero.getHeroId());
        return "redirect:viewheroes";
    }

    @RequestMapping(value = "/editlocation", method = RequestMethod.POST)
    public String editLocation(HttpServletRequest request) {
        try {
            //create new location
            Location newLoc = new Location();
            //get the id of the location to be edited...
            String locationIdParameter = request.getParameter("locationId");
            int locationId = Integer.parseInt(locationIdParameter);
            //...and set that id to the new location
            newLoc.setLocationId(locationId);
            Location oldLoc = dao.getLocationById(locationId);
            //if the field has new data, pass that data into the new location object...
            //...if not, use the old location to pass the old data into the new location
            String name = request.getParameter("locationName");
            if (name.length() > 0) {
                newLoc.setLocationName(name);
            } else {
                newLoc.setLocationName(oldLoc.getLocationName());
            }
            String address = request.getParameter("address");
            if (address.length() > 0) {
                newLoc.setAddress(address);
            } else {
                newLoc.setAddress(oldLoc.getAddress());
            }
            String latString = request.getParameter("latitude");
            if (latString.length() > 0) {
                double lat = Double.parseDouble(latString);
                newLoc.setLatitude(lat);
            } else {
                newLoc.setLatitude(oldLoc.getLatitude());
            }
            String lonString = request.getParameter("longitude");
            if (lonString.length() > 0) {
                double lon = Double.parseDouble(lonString);
                newLoc.setLongitude(lon);
            } else {
                newLoc.setLongitude(oldLoc.getLongitude());
            }
            //last, delete the old location...
            dao.addLocation(newLoc);
            //...and add the new one
            dao.deleteLocation(oldLoc.getLocationId());
        } catch (NumberFormatException ex) {
            return "redirect:viewlocations";
        }
        return "redirect:viewlocations";
    }

    @RequestMapping(value = "/editorg", method = RequestMethod.POST)
    public String editOrg(HttpServletRequest request) {
        //create new organization
        Organization newOrg = new Organization();
        //get the id of the organization to be edited...
        String orgIdParameter = request.getParameter("organizationId");
        int orgId = Integer.parseInt(orgIdParameter);
        //...and set that id to the new organization
        newOrg.setOrganizationId(orgId);
        Organization oldOrg = dao.getOrganizationById(orgId);
        //if the field has new data, pass that data into the new organization object...
        //...if not, use the old organization to pass the old data into the new organization
        String name = request.getParameter("orgName");
        if (name.length() > 0) {
            newOrg.setOrgName(name);
        } else {
            newOrg.setOrgName(oldOrg.getOrgName());
        }
        String loc = request.getParameter("location");
        if (loc != null) {
            int locationInt = Integer.parseInt(loc);
            Location orgLoc = dao.getLocationById(locationInt);
            newOrg.setLocation(orgLoc);
        } else {
            newOrg.setLocation(oldOrg.getLocation());
        }
        String phone = request.getParameter("phone");
        if (phone.length() > 0) {
            newOrg.setPhone(phone);
        } else {
            newOrg.setPhone(oldOrg.getPhone());
        }
        String email = request.getParameter("email");
        if (email.length() > 0) {
            newOrg.setEmail(email);
        } else {
            newOrg.setEmail(oldOrg.getEmail());
        }
        String[] selectedHeroes = request.getParameterValues("orgHero");
        if (selectedHeroes != null) {
            List<Hero> heroList = new ArrayList<>();
            for (String heroString : selectedHeroes) {
                int heroInt = Integer.parseInt(heroString);
                Hero hero = dao.getHeroById(heroInt);
                heroList.add(hero);
            }
            newOrg.setOrgHero(heroList);
        } else {
            newOrg.setOrgHero(oldOrg.getOrgHero());
        }
        //last, delete the old organization...
        dao.addOrganization(newOrg);
        //...and add the new one
        dao.deleteOrganization(oldOrg.getOrganizationId());
        return "redirect:vieworgs";
    }

    @RequestMapping(value = "/editpower", method = RequestMethod.POST)
    public String editPower(HttpServletRequest request) {
        //create new power
        Power newPow = new Power();
        //get the id of the power to be edited...
        String powerIdParameter = request.getParameter("powerId");
        int powerId = Integer.parseInt(powerIdParameter);
        //...and set that id to the new power
        newPow.setPowerId(powerId);
        Power oldPow = dao.getPowerById(powerId);
        //if the field has new data, pass that data into the new power object...
        //...if not, use the old power to pass the old data into the new power
        String desc = request.getParameter("powerDescription");
        if (desc.length() > 0) {
            newPow.setPowerDescription(desc);
        } else {
            newPow.setPowerDescription(oldPow.getPowerDescription());
        }
        //last, delete the old power...
        dao.addPower(newPow);
        //...and add the new one
        dao.deletePower(oldPow.getPowerId());
        return "redirect:viewpowers";
    }

    @RequestMapping(value = "/editsighting", method = RequestMethod.POST)
    public String editSighting(HttpServletRequest request) {
        try {
            //create new sighting
            Sighting newSight = new Sighting();
            //get the id of the sighting to be edited...
            String sightingIdParameter = request.getParameter("sightingId");
            int sightingId = Integer.parseInt(sightingIdParameter);
            //...and set that id to the new sighting
            newSight.setSightingId(sightingId);
            Sighting oldSight = dao.getSightingById(sightingId);
            //if the field has new data, pass that data into the new sighting object...
            //...if not, use the old sighting to pass the old data into the new sighting
            String loc = request.getParameter("location");
            if (loc != null) {
                int locationInt = Integer.parseInt(loc);
                Location sightLoc = dao.getLocationById(locationInt);
                newSight.setLocation(sightLoc);
            } else {
                newSight.setLocation(oldSight.getLocation());
            }
            String date = request.getParameter("date");
            if (date.length() > 0) {
                LocalDate localDate = LocalDate.parse(date);
                newSight.setDate(localDate);
            } else {
                newSight.setDate(oldSight.getDate());
            }
            String desc = request.getParameter("sightingDescription");
            if (desc.length() > 0) {
                newSight.setSightingDescription(desc);
            } else {
                newSight.setSightingDescription(oldSight.getSightingDescription());
            }
            String[] selectedHeroes = request.getParameterValues("sightingHero");
            if (selectedHeroes != null) {
                List<Hero> heroList = new ArrayList<>();
                for (String heroString : selectedHeroes) {
                    int heroInt = Integer.parseInt(heroString);
                    Hero hero = dao.getHeroById(heroInt);
                    heroList.add(hero);
                }
                newSight.setSightingHero(heroList);
            } else {
                newSight.setSightingHero(oldSight.getSightingHero());
            }
            //last, delete the old sighting...
            dao.addSighting(newSight);
            //...and add the new one
            dao.deleteSighting(oldSight.getSightingId());
        } catch (DateTimeParseException ex) {
            return "redirect:viewsightings";
        }
        return "redirect:viewsightings";
    }
//==============================================================================
//DISPLAY LAST 10 OBJECTS METHOD
//==============================================================================   

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLastTenSightings(Map<String, Object> model) {
        //add the last ten sightings to model
        List<Sighting> lastTen = dao.getLastTenSightings();
        model.put("lastTen", lastTen);
        return "index";
    }

}
