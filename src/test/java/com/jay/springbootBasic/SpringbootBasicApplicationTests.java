package com.jay.springbootBasic;

import java.math.BigDecimal;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jay.entities.Account;
import com.jay.repositories.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SpringbootBasicApplicationTests {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetAccounts() throws Exception {
		List<Account> accounts = accountRepository.findAll();
		assertThat(accounts.size(), is(3));
	}
	
	@Test
	public void testGetAccount() throws Exception {
		Account account = accountRepository.findOne(1L);
		assertThat(account.getId(), is(1L));
		assertThat(account.getBalance(), is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
	}
	
	@Test
	public void testGetNumberOfAccounts() throws Exception {
		assertThat(accountRepository.count(), is(3L));
	}
	
	@Test
	public void testCreateAccount() throws Exception {
		Account account = new Account(4L, new BigDecimal("200.0"));
		accountRepository.save(account);
		Long id = account.getId();
		assertThat(id, is(notNullValue()));
		
		Account again = accountRepository.findOne(id);
		assertThat(again.getId(), is(id));
		assertThat(again.getBalance(), is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
	}
	
	@Test
	public void testUpdateAccount() throws Exception {
		Account account = accountRepository.findOne(1L);
		BigDecimal current = account.getBalance();
		BigDecimal amount = new BigDecimal("20.0");
		
		account.setBalance(current.add(amount));
		accountRepository.save(account);
		
		assertThat(accountRepository.findOne(1L).getBalance(), is(closeTo(current.add(amount), new BigDecimal("0.01"))));
	}

	@Test
	public void testDeleteAccount() throws Exception {
		accountRepository.deleteAll();
		assertThat(accountRepository.count(), is(0L));
	}
}
