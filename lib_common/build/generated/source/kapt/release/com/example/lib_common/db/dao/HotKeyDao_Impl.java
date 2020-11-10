package com.example.lib_common.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.lib_common.model.Hotkey;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HotKeyDao_Impl implements HotKeyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Hotkey> __insertionAdapterOfHotkey;

  private final EntityDeletionOrUpdateAdapter<Hotkey> __deletionAdapterOfHotkey;

  private final EntityDeletionOrUpdateAdapter<Hotkey> __updateAdapterOfHotkey;

  public HotKeyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHotkey = new EntityInsertionAdapter<Hotkey>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `hotkey` (`id`,`link`,`name`,`order`,`visible`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Hotkey value) {
        stmt.bindLong(1, value.getId());
        if (value.getLink() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLink());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindLong(4, value.getOrder());
        stmt.bindLong(5, value.getVisible());
      }
    };
    this.__deletionAdapterOfHotkey = new EntityDeletionOrUpdateAdapter<Hotkey>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `hotkey` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Hotkey value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfHotkey = new EntityDeletionOrUpdateAdapter<Hotkey>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `hotkey` SET `id` = ?,`link` = ?,`name` = ?,`order` = ?,`visible` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Hotkey value) {
        stmt.bindLong(1, value.getId());
        if (value.getLink() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLink());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindLong(4, value.getOrder());
        stmt.bindLong(5, value.getVisible());
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final List<Hotkey> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHotkey.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Hotkey element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHotkey.insert(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Hotkey element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHotkey.handle(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteList(final List<Hotkey> elements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHotkey.handleMultiple(elements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSome(final Hotkey... elements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHotkey.handleMultiple(elements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Hotkey element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfHotkey.handle(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Hotkey> getAllHotKey() {
    final String _sql = "select * from hotkey";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "link");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "order");
      final int _cursorIndexOfVisible = CursorUtil.getColumnIndexOrThrow(_cursor, "visible");
      final List<Hotkey> _result = new ArrayList<Hotkey>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Hotkey _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpLink;
        _tmpLink = _cursor.getString(_cursorIndexOfLink);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final int _tmpOrder;
        _tmpOrder = _cursor.getInt(_cursorIndexOfOrder);
        final int _tmpVisible;
        _tmpVisible = _cursor.getInt(_cursorIndexOfVisible);
        _item = new Hotkey(_tmpId,_tmpLink,_tmpName,_tmpOrder,_tmpVisible);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
