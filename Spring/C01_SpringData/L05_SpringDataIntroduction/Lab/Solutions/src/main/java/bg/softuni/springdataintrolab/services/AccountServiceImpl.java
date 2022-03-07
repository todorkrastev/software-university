package bg.softuni.springdataintrolab.services;

import bg.softuni.springdataintrolab.exceptions.InsufficientFundsException;
import bg.softuni.springdataintrolab.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void transferBetweenAccounts(Long fromId, Long toId, BigDecimal amount) throws InsufficientFundsException {
        /*
        var from = accountRepository.findById(fromId).orElseThrow();
        if (from.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException();
        }
        from.setBalance(from.getBalance().subtract(amount));

        var to = accountRepository.findById(toId).orElseThrow();
        to.setBalance(to.getBalance().add(amount));
         */

        this.withdrawMoney(amount, fromId);
        this.transferMoney(amount, toId);
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) throws InsufficientFundsException {
        var account = this.accountRepository.findById(id).orElseThrow();
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException();
        }

        account.setBalance(account.getBalance().subtract(amount));
        this.accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {
        var account = this.accountRepository.findById(id).orElseThrow();

        account.setBalance(account.getBalance().add(amount));
        this.accountRepository.save(account);
    }
}
