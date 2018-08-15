package com.faraway.moneytransfer.resource;

import com.faraway.moneytransfer.dto.MoneyDto;
import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.Money;
import com.faraway.moneytransfer.service.FinanceService;
import com.faraway.moneytransfer.dto.AccountDto;
import com.faraway.moneytransfer.util.AccountMapper;
import com.faraway.moneytransfer.util.MoneyMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.Form;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;

@Path("/finance")
public class FinanceResource implements Resource {

	@Inject
	private FinanceService financeService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/transfermoney")
	public boolean transferMoney(ParamsWrapper paramsWrapper) {
		AccountMapper mapper = AccountMapper.INSTANCE;
		MoneyMapper moneyMapper = MoneyMapper.INSTANCE;
		return financeService.transferMoney(
				mapper.accountDtoAsAccount(paramsWrapper.accFrom),
				mapper.accountDtoAsAccount(paramsWrapper.accTo),
				moneyMapper.moneyDtoAsMoney(paramsWrapper.money));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/account")
	public AccountDto getAccountById(@QueryParam("id") int id) {
		AccountMapper mapper = AccountMapper.INSTANCE;
		return mapper.accountAsAccountDto(financeService.getAccountById(id));
	}

	static class ParamsWrapper {
		AccountDto accFrom;
		AccountDto accTo;
		MoneyDto money;

		public ParamsWrapper() {}

		public AccountDto getAccFrom() {
			return accFrom;
		}

		public void setAccFrom(AccountDto accFrom) {
			this.accFrom = accFrom;
		}

		public AccountDto getAccTo() {
			return accTo;
		}

		public void setAccTo(AccountDto accTo) {
			this.accTo = accTo;
		}

		public MoneyDto getMoney() {
			return money;
		}

		public void setMoney(MoneyDto money) {
			this.money = money;
		}
	}
}
