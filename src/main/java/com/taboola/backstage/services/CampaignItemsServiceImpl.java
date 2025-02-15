package com.taboola.backstage.services;

import com.taboola.backstage.exceptions.BackstageAPIConnectivityException;
import com.taboola.backstage.exceptions.BackstageAPIRequestException;
import com.taboola.backstage.exceptions.BackstageAPIUnauthorizedException;
import com.taboola.backstage.internal.BackstageCampaignItemsEndpoint;
import com.taboola.backstage.model.Results;
import com.taboola.backstage.model.auth.BackstageAuthentication;
import com.taboola.backstage.model.media.campaigns.items.CampaignItem;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemMassiveCreationOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemMassiveOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemMassiveUpdateOperation;
import com.taboola.backstage.model.media.campaigns.items.CampaignItemOperation;
import com.taboola.rest.api.internal.FieldsValidator;

/**
 * Created by vladi
 * Date: 10/16/2017
 * Time: 11:47 PM
 * By Taboola
 */
public class CampaignItemsServiceImpl implements CampaignItemsService {

    private final BackstageCampaignItemsEndpoint endpoint;
    private final Boolean performValidations;

    public CampaignItemsServiceImpl(Boolean performValidations, BackstageCampaignItemsEndpoint endpoint) {
        this.endpoint = endpoint;
        this.performValidations = performValidations;
    }

    @Override
    public CampaignItem createItem(BackstageAuthentication auth, String accountId, String campaignId, CampaignItemOperation campaignItemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(campaignItemOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createItem(accessToken, accountId, campaignId, campaignItemOperation);
    }

    @Override
    public Results<CampaignItem> createMassive(BackstageAuthentication auth, String accountId, String campaignId, CampaignItemMassiveOperation massiveOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(massiveOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.createMassive(accessToken, accountId, campaignId, massiveOperation);
    }

    @Override
    public Results<CampaignItem> createMassive(BackstageAuthentication auth, String accountId, CampaignItemMassiveCreationOperation massiveCreationOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateCreateOperation(massiveCreationOperation);
        }

        return endpoint.createCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(), accountId, massiveCreationOperation);
    }


    @Override
    public Results<CampaignItem> updateMassive(BackstageAuthentication auth, String accountId, CampaignItemMassiveUpdateOperation massiveUpdateOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return updateMassive(auth, Boolean.TRUE, accountId, massiveUpdateOperation);
    }

    @Override
    public Results<CampaignItem> updateMassive(BackstageAuthentication auth, boolean isAtomic, String accountId, CampaignItemMassiveUpdateOperation massiveUpdateOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(massiveUpdateOperation);
        }

        return endpoint.updateCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(), accountId, isAtomic, massiveUpdateOperation);
    }

    @Override
    public Results<CampaignItem> deleteMassive(BackstageAuthentication auth, String accountId, CampaignItemMassiveUpdateOperation massiveUpdateOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        return deleteMassive(auth, Boolean.TRUE, accountId, massiveUpdateOperation);
    }

    @Override
    public Results<CampaignItem> deleteMassive(BackstageAuthentication auth, boolean isAtomic, String accountId, CampaignItemMassiveUpdateOperation massiveUpdateOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(massiveUpdateOperation);
        }

        return endpoint.deleteCrossCampaignsMassive(auth.getToken().getAccessTokenForHeader(), accountId, isAtomic, massiveUpdateOperation);
    }

    @Override
    public Results<CampaignItem> readItems(BackstageAuthentication auth, String accountId, String campaignId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readItems(accessToken, accountId, campaignId);
    }

    @Override
    public Results<CampaignItem> readRSSChildrenItems(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIRequestException, BackstageAPIUnauthorizedException, BackstageAPIConnectivityException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readRSSChildrenItems(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public CampaignItem readSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, String childId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readSpecificRSSChildItem(accessToken, accountId, campaignId, itemId, childId);
    }

    @Override
    public CampaignItem updateSpecificRSSChildItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, String childId, CampaignItemOperation campaignItemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(campaignItemOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateSpecificRSSChildItem(accessToken, accountId, campaignId, itemId, childId, campaignItemOperation);
    }

    @Override
    public CampaignItem readItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.readItem(accessToken, accountId, campaignId, itemId);
    }

    @Override
    public CampaignItem updateItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId, CampaignItemOperation campaignItemOperation) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        if(performValidations) {
            FieldsValidator.validateUpdateOperation(campaignItemOperation);
        }
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.updateItem(accessToken, accountId, campaignId, itemId, campaignItemOperation);
    }

    @Override
    public CampaignItem deleteItem(BackstageAuthentication auth, String accountId, String campaignId, String itemId) throws BackstageAPIUnauthorizedException, BackstageAPIConnectivityException, BackstageAPIRequestException {
        String accessToken = auth.getToken().getAccessTokenForHeader();
        return endpoint.deleteItem(accessToken, accountId, campaignId, itemId);
    }
}
