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

    const val URI_CHAMPION_MASTERY = "/lol/champion-mastery/${VERSION}/"
    const val URI_CHAMPION_MASTERIES_BY_SUMMONER = URI_CHAMPION_MASTERY + "champion-masteries/by-summoner/{summonerId}"//Get all champion mastery entries sorted by number of champion points descending,
    const val URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION = URI_CHAMPION_MASTERY + "champion-masteries/by-summoner/{summonerId}/by-champion/{championId}" //Get a champion mastery by player ID and champion ID.
    const val URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER = URI_CHAMPION_MASTERY + "scores/by-summoner/{summonerId}" //Get a player's total champion mastery score, which is the sum of individual champion mastery levels

    const val URI_CHAMPIONS = "/lol/platform/${VERSION}/champions" //Retrieve all championData.
    const val URI_CHAMPION = "/lol/platform/${VERSION}/champions/{id}" //Retrieve champion by ID.

    const val URI_LEAGUE = "/lol/league/${VERSION}/"
    const val URI_LEAGUE_CHALLENGER_BY_QUEUE = URI_LEAGUE + "challengerleagues/by-queue/{queue}" //Get the challenger league for given queue.
    const val URI_LEAGUE_BY_ID =URI_LEAGUE +  "leagues/{leagueId}" //Get league with given ID, including inactive entries.
    const val URI_LEAGUE_MASTER_BY_QUEUE = URI_LEAGUE + "masterleagues/by-queue/{queue}" //Get the master league for given queue.
    const val URI_LEAGUE_POSITION_BY_SUMMONER =URI_LEAGUE +  "positions/by-summoner/{summonerId}" //Get league positions in all queues for a given summoner ID

    const val URI_LOL_STATUS = "/lol/status/${VERSION}/shard-data"

   const val URI_MATCH_BY_ID = "/lol/match/${VERSION}/matches/{matchId}" //Get match by match ID.
   const val URI_MATCH_LIST_BY_ACCOUNT = "/lol/match/${VERSION}/matchlists/by-account/{accountId}"//Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   const val URI_MATCH_LIST_BY_ACCOUNT_RECENT = "/lol/match/${VERSION}/matchlists/by-account/{accountId}/recent"//Get matchlist for last 20 matches played on given account ID and platform ID.
   const val URI_MATCH_TIMELINE_BY_ID = "/lol/match/${VERSION}/timelines/by-match/{matchId}"//Get match timelineMatch by match ID.
   const val URI_IDS_MATCH_LIST_BY_TOURNAMENT = "/lol/match/${VERSION}/matches/by-tournament-code/{tournamentCode}/ids"// Get match IDs by tournament code.
   const val URI_MATCH_BY_ID_BY_TOUNRAMENT = "/lol/match/${VERSION}/matches/{matchId}/by-tournament-code/{tournamentCode}"//Get match by match ID and tournament code

    const val URI_SPECTATOR = "/lol/spectator/${VERSION}/"
    const val URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID =  URI_SPECTATOR + "active-games/by-summoner/{summonerId}" //Get current game information for the given summoner ID.
    const val URI_SPECTATOR_FEATURED_GAME = URI_SPECTATOR + "featured-games"//Get list of featured games
}