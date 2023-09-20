package com.bassure.ims.productservice.service;

import com.bassure.ims.productservice.request.AssetRequest;
import com.bassure.ims.productservice.response.ResponseEntity;

public interface AssetService {

    public ResponseEntity addAsset(AssetRequest assetRequest);

    public ResponseEntity getAsset();

    public ResponseEntity getAssetById(String assetId);

    public ResponseEntity getAggregatedAssets();

    public ResponseEntity retrieveAggregatedAsset();

    public ResponseEntity updateAsset(String assetId, AssetRequest anAssetRequest);

    public ResponseEntity deleteAsset(String id);
}
