package com.example.lib_common.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.lib_common.db.dao.HotKeyDao;
import com.example.lib_common.db.dao.HotKeyDao_Impl;
import com.example.lib_common.db.dao.SearchHistoryDao;
import com.example.lib_common.db.dao.SearchHistoryDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile SearchHistoryDao _searchHistoryDao;

  private volatile HotKeyDao _hotKeyDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `shistory` (`sId` INTEGER, `key_word` TEXT, PRIMARY KEY(`sId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `hotkey` (`id` INTEGER NOT NULL, `link` TEXT NOT NULL, `name` TEXT NOT NULL, `order` INTEGER NOT NULL, `visible` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '877a94d0b4b542f265cb564769fd66ff')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `shistory`");
        _db.execSQL("DROP TABLE IF EXISTS `hotkey`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsShistory = new HashMap<String, TableInfo.Column>(2);
        _columnsShistory.put("sId", new TableInfo.Column("sId", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsShistory.put("key_word", new TableInfo.Column("key_word", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShistory = new TableInfo("shistory", _columnsShistory, _foreignKeysShistory, _indicesShistory);
        final TableInfo _existingShistory = TableInfo.read(_db, "shistory");
        if (! _infoShistory.equals(_existingShistory)) {
          return new RoomOpenHelper.ValidationResult(false, "shistory(com.example.lib_common.model.SearchHistory).\n"
                  + " Expected:\n" + _infoShistory + "\n"
                  + " Found:\n" + _existingShistory);
        }
        final HashMap<String, TableInfo.Column> _columnsHotkey = new HashMap<String, TableInfo.Column>(5);
        _columnsHotkey.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHotkey.put("link", new TableInfo.Column("link", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHotkey.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHotkey.put("order", new TableInfo.Column("order", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHotkey.put("visible", new TableInfo.Column("visible", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHotkey = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHotkey = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHotkey = new TableInfo("hotkey", _columnsHotkey, _foreignKeysHotkey, _indicesHotkey);
        final TableInfo _existingHotkey = TableInfo.read(_db, "hotkey");
        if (! _infoHotkey.equals(_existingHotkey)) {
          return new RoomOpenHelper.ValidationResult(false, "hotkey(com.example.lib_common.model.Hotkey).\n"
                  + " Expected:\n" + _infoHotkey + "\n"
                  + " Found:\n" + _existingHotkey);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "877a94d0b4b542f265cb564769fd66ff", "3603ddb5d758bc966cf0210d9bbf1707");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "shistory","hotkey");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `shistory`");
      _db.execSQL("DELETE FROM `hotkey`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public SearchHistoryDao getSearchHistoryDao() {
    if (_searchHistoryDao != null) {
      return _searchHistoryDao;
    } else {
      synchronized(this) {
        if(_searchHistoryDao == null) {
          _searchHistoryDao = new SearchHistoryDao_Impl(this);
        }
        return _searchHistoryDao;
      }
    }
  }

  @Override
  public HotKeyDao getHotKeyDao() {
    if (_hotKeyDao != null) {
      return _hotKeyDao;
    } else {
      synchronized(this) {
        if(_hotKeyDao == null) {
          _hotKeyDao = new HotKeyDao_Impl(this);
        }
        return _hotKeyDao;
      }
    }
  }
}
