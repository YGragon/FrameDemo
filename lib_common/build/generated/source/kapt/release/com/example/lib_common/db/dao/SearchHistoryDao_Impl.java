package com.example.lib_common.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.lib_common.model.SearchHistory;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SearchHistoryDao_Impl implements SearchHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SearchHistory> __insertionAdapterOfSearchHistory;

  private final EntityDeletionOrUpdateAdapter<SearchHistory> __deletionAdapterOfSearchHistory;

  private final EntityDeletionOrUpdateAdapter<SearchHistory> __updateAdapterOfSearchHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSearchHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SearchHistoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSearchHistory = new EntityInsertionAdapter<SearchHistory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `shistory` (`sId`,`key_word`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SearchHistory value) {
        if (value.getSId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSId());
        }
        if (value.getKeyWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyWord());
        }
      }
    };
    this.__deletionAdapterOfSearchHistory = new EntityDeletionOrUpdateAdapter<SearchHistory>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `shistory` WHERE `sId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SearchHistory value) {
        if (value.getSId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSId());
        }
      }
    };
    this.__updateAdapterOfSearchHistory = new EntityDeletionOrUpdateAdapter<SearchHistory>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `shistory` SET `sId` = ?,`key_word` = ? WHERE `sId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SearchHistory value) {
        if (value.getSId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getSId());
        }
        if (value.getKeyWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyWord());
        }
        if (value.getSId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getSId());
        }
      }
    };
    this.__preparedStmtOfDeleteSearchHistory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from shistory where key_word = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from shistory";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<SearchHistory> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSearchHistory.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final SearchHistory element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSearchHistory.insert(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SearchHistory element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSearchHistory.handle(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteList(final List<SearchHistory> elements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSearchHistory.handleMultiple(elements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSome(final SearchHistory... elements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSearchHistory.handleMultiple(elements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SearchHistory element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSearchHistory.handle(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSearchHistory(final String key_word) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSearchHistory.acquire();
    int _argIndex = 1;
    if (key_word == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, key_word);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSearchHistory.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<SearchHistory> getAllSearchHistory() {
    final String _sql = "select * from shistory";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSId = CursorUtil.getColumnIndexOrThrow(_cursor, "sId");
      final int _cursorIndexOfKeyWord = CursorUtil.getColumnIndexOrThrow(_cursor, "key_word");
      final List<SearchHistory> _result = new ArrayList<SearchHistory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SearchHistory _item;
        final Long _tmpSId;
        if (_cursor.isNull(_cursorIndexOfSId)) {
          _tmpSId = null;
        } else {
          _tmpSId = _cursor.getLong(_cursorIndexOfSId);
        }
        final String _tmpKeyWord;
        _tmpKeyWord = _cursor.getString(_cursorIndexOfKeyWord);
        _item = new SearchHistory(_tmpSId,_tmpKeyWord);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
