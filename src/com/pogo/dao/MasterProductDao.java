package com.pogo.dao;

import java.util.List;

import com.pogo.model.Currency;
import com.pogo.model.Unit;

public interface MasterProductDao {

	List<Currency> getCurrencyData();

	void addCurrency(Currency cur);

	void deleteCurrency(int id);

	List<Currency> getCurrency(String id);

	void editCurrency(Currency cur);

	List<Unit> getUnitsData();

	void addUnit(Unit cur);

	void deleteUnit(int id);

	List<Unit> getUnitById(String id);

	void editUnit(Unit cur);

}
