package com.daonq1408.workshopbesql.service;

import com.daonq1408.workshopbesql.dto.request.AccountRequest;
import com.daonq1408.workshopbesql.dto.request.RegisterRequest;
import com.daonq1408.workshopbesql.dto.response.AccountResponse;
import com.daonq1408.workshopbesql.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(AccountRequest accountRequest);
    AccountResponse register(RegisterRequest registerRequest);
}
