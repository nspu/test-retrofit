package fr.nspu.riot_api.services

/**
 * Created by nspu on 11/03/18.
 */
object RiotUri {
    const val VERSION = "v3"

    const val URI_SUFFIX_STATIC_DATA = "/lol/static-data/${VERSION}/"
    const val URI_STATIC_DATA_CHAMPIONS = URI_SUFFIX_STATIC_DATA + "championData" //Retrieves champion list
    const val URI_STATIC_DATA_CHAMPION = URI_SUFFIX_STATIC_DATA + "championData/{id}" //Retrieves champion by ID
    const val URI_STATIC_DATA_ITEMS = URI_SUFFIX_STATIC_DATA + "items" //Retrieves item list
    const val URI_STATIC_DATA_ITEM = URI_SUFFIX_STATIC_DATA + "items/{id}" //Retrieves item by ID
    const val URI_STATIC_DATA_LANGUAGE_STRING = URI_SUFFIX_STATIC_DATA + "language-strings" //Retrieve language strings data
    const val URI_STATIC_DATA_LANGUAGES = URI_SUFFIX_STATIC_DATA + "languages" //Retrieve supported languages data
    const val URI_STATIC_DATA_MAPS = URI_SUFFIX_STATIC_DATA + "maps" //Retrieve map data
    const val URI_STATIC_DATA_MASTERIES = URI_SUFFIX_STATIC_DATA + "masteries" //Retrieves mastery list
    const val URI_STATIC_DATA_MASTERY = URI_SUFFIX_STATIC_DATA + "masteries/{id}" //Retrieves mastery item by ID
    const val URI_STATIC_DATA_PROFILE_ICONS = URI_SUFFIX_STATIC_DATA + "profile-icons" //Retrieve profile icons
    const val URI_STATIC_DATA_REALMS = URI_SUFFIX_STATIC_DATA + "realms" //Retrieve realm data
    const val URI_STATIC_DATA_REFORGED_RUNE_PATHS = URI_SUFFIX_STATIC_DATA + "reforged-rune-paths" // Retrieves reforged rune path list
    const val URI_STATIC_DATA_REFORGED_RUNE_PATH = URI_SUFFIX_STATIC_DATA + "reforged-rune-paths/{id}" // Retrieves reforged rune path by ID
    const val URI_STATIC_DATA_REFORGED_RUNES = URI_SUFFIX_STATIC_DATA + "reforged-runes" // Retrieves reforged rune list
    const val URI_STATIC_DATA_REFORGED_RUNE = URI_SUFFIX_STATIC_DATA + "reforged-runes/{id}" // Retrieves reforged rune by ID
    const val URI_STATIC_DATA_RUNES = URI_SUFFIX_STATIC_DATA + "runes" // Retrieves rune list
    const val URI_STATIC_DATA_RUNE = URI_SUFFIX_STATIC_DATA + "runes/{id}" // Retrieves rune by ID
    const val URI_STATIC_DATA_SUMMONER_SPELLS = URI_SUFFIX_STATIC_DATA + "summoner-spells" // Retrieves summoner spell list
    const val URI_STATIC_DATA_SUMMONER_SPELL = URI_SUFFIX_STATIC_DATA + "summoner-spells/{id}" // Retrieves summoner spell by ID
    const val URI_STATIC_DATA_TARBALL_LINKS = URI_SUFFIX_STATIC_DATA + "tarball-links" // Retrieves full tarball link
    const val URI_STATIC_DATA_VERSIONS = URI_SUFFIX_STATIC_DATA + "versions" // Retrives version data


    const val URI_CHAMPION_MASTERY ="/lol/champion-mastery/${VERSION}/"
    const val URI_CHAMPION_MASTERIES_BY_SUMMONER = URI_CHAMPION_MASTERY + "champion-masteries/by-summoner/{summonerId}"//Get all champion mastery entries sorted by number of champion points descending,
    const val URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION = URI_CHAMPION_MASTERY + "champion-masteries/by-summoner/{summonerId}/by-champion/{championId}" //Get a champion mastery by player ID and champion ID.
    const val URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER = URI_CHAMPION_MASTERY + "scores/by-summoner/{summonerId}" //Get a player's total champion mastery score, which is the sum of individual champion mastery levels


    const val URI_CHAMPIONS = "/lol/platform/${VERSION}/champions" //Retrieve all championData.
    const val URI_CHAMPION = "/lol/platform/${VERSION}/champions/{id}" //Retrieve champion by ID.
}