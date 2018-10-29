/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author austinmann
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
public class Hero {
    
    private int heroId;
    private String heroName;
    private String heroDescription;
    private List<Power> power;
}
