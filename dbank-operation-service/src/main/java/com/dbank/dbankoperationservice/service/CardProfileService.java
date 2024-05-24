package com.dbank.dbankoperationservice.service;

import com.dbank.dbankoperationservice.entity.CardProfile;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;

public interface CardProfileService {

    CardProfile getById(long cardProfileId) throws EntityNotFoundException;
}
