package com.daonq1408.workshopbesql.utils;

import com.daonq1408.workshopbesql.entity.Account;
import com.daonq1408.workshopbesql.repository.AccountRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil implements ApplicationContextAware {

    private static AccountRepository accountRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        accountRepository = applicationContext.getBean(AccountRepository.class);
    }

    public Account getCurrentAccount() {
        String mail = SecurityContextHolder.getContext().getAuthentication().getName();
        return accountRepository.findByMail(mail).orElse(null);
    }
}
