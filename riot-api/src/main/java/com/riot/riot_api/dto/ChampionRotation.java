package com.riot.riot_api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChampionRotation {

    private List<Long> freeChampionIds;
    private List<Long> freeChampionIdsForNewPlayers;
}
