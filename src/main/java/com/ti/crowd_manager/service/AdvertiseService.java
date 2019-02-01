package com.ti.crowd_manager.service;

import com.ti.crowd_manager.domain.Advertisement;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdvertiseService {

    void addAdvertise(Advertisement ad);

    HashMap<String,ArrayList> getAdvertise();
}
