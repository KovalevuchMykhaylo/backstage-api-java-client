package com.taboola.backstage;

import com.taboola.backstage.model.Account;
import com.taboola.backstage.model.auth.AuthenticationDetails;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.auth.GrantType;
import com.taboola.backstage.model.auth.Token;
import com.taboola.backstage.model.dictionary.Resource;
import com.taboola.backstage.model.media.campaigns.Campaign;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.model.media.reports.TopCampaignContentReport;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by vladi
 * Date: 11/14/2017
 * Time: 10:26 PM
 * By Taboola
 */
public abstract class BackstageTestBase {

    protected static final PodamFactory factory = new PodamFactoryImpl();

    protected BackstageAuthentication generateDummyPasswordBackstageAuth() {
        return new BackstageAuthentication(generateDummyPasswordAuthenticationDetails(), generateDummyToken());
    }

    protected BackstageAuthentication generateDummyClientCredentialsBackstageAuth() {
        return new BackstageAuthentication(generateDummyClientCredAuthenticationDetails(), generateDummyToken());
    }

    protected AuthenticationDetails generateDummyPasswordAuthenticationDetails() {
        return new AuthenticationDetails("DummyClientId", "DummyClientSecret",
        "DummyUsername", "DummyPassword", GrantType.PASSWORD_AUTHENTICATION);
    }

    protected AuthenticationDetails generateDummyClientCredAuthenticationDetails() {
        return new AuthenticationDetails("DummyClientId", "DummyClientSecret",
        null, null, GrantType.CLIENT_CREDENTIALS);
    }

    protected Token generateDummyToken() {
        Token token = new Token();
        token.setAccessToken("accesstoken");
        token.setExpiresIn(1000);
        token.setRefreshToken("refreshtoken");
        token.setTokenType("bearer");
        return token;
    }

    protected Account generateDummyAccount() {
        return factory.manufacturePojo(Account.class);
    }

    protected Campaign generateDummyCampaign() {
        return factory.manufacturePojo(Campaign.class);
    }

    protected CampaignItem generateDummyCamppaignItem() {
        return factory.manufacturePojo(CampaignItem.class);
    }

    protected Resource generateDummyResource() {
        return factory.manufacturePojo(Resource.class);
    }

    protected TopCampaignContentReport generateDummyTopCampaignContentReport() {
        return factory.manufacturePojo(TopCampaignContentReport.class);
    }
}
