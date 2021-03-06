package Riot.domain;

import lombok.Data;

@Data
public class SummonerDto {
    private String accountId;
    private int profileIconId;
    private long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
    public SummonerDto(String accountId, int profileIconId, long revisionDate, String name, String id, String puuid, long summonerLevel){
        this.accountId=accountId;
        this.profileIconId=profileIconId;;
        this.revisionDate=revisionDate;
        this.name=name;
        this.id=id;
        this.puuid=puuid;
        this.summonerLevel=summonerLevel;
    }
}
