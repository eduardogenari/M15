package com.M15;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.M15.dao.IDiceDao;
import com.M15.dao.IPlayerDao;
import com.M15.dto.Dice;
import com.M15.dto.Player;

@Component
public class DbSeeder implements CommandLineRunner {
	private IPlayerDao iPlayerDao;
	private IDiceDao iDiceDao;

	public DbSeeder(IPlayerDao iPlayerDao, IDiceDao iDiceDao) {
		this.iPlayerDao = iPlayerDao;
		this.iDiceDao = iDiceDao;
	}

	@Override
	public void run(String... args) throws Exception {
		// drop existing data
		iPlayerDao.deleteAll();
		iDiceDao.deleteAll();
		// create data
		Player piero = new Player("1","Piero", "notencoded");
		piero.setRole(com.M15.security.DiceGameRoles.AUTHOR);
		Player jonatan = new Player("2","Jonatan", "iknowitsnosafe");
		jonatan.setRole(com.M15.security.DiceGameRoles.ADMIN);
		iPlayerDao.save(piero);
		iPlayerDao.save(jonatan);
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));

		iPlayerDao.save(new Player("3", "LuckySeven", "casinodestroyer"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));

		iPlayerDao.save(new Player("4", "AzarLover", "wastetimeandomoney"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));

	}

}
