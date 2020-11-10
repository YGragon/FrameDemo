package com.example.lib_common.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.lib_common.db.IntegerConverter;
import com.example.lib_common.db.StringTypeConverter;
import com.example.lib_common.model.User;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final StringTypeConverter __stringTypeConverter = new StringTypeConverter();

  private final IntegerConverter __integerConverter = new IntegerConverter();

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user` (`chapterTops`,`collectIds`,`email`,`icon`,`id`,`password`,`token`,`type`,`username`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        final String _tmp;
        _tmp = __stringTypeConverter.someObjectListToString(value.getChapterTops());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = __integerConverter.someIntegerListToString(value.getCollectIds());
        if (_tmp_1 == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp_1);
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getIcon() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIcon());
        }
        stmt.bindLong(5, value.getId());
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        if (value.getToken() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getToken());
        }
        stmt.bindLong(8, value.getType());
        if (value.getUsername() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUsername());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user` SET `chapterTops` = ?,`collectIds` = ?,`email` = ?,`icon` = ?,`id` = ?,`password` = ?,`token` = ?,`type` = ?,`username` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        final String _tmp;
        _tmp = __stringTypeConverter.someObjectListToString(value.getChapterTops());
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, _tmp);
        }
        final String _tmp_1;
        _tmp_1 = __integerConverter.someIntegerListToString(value.getCollectIds());
        if (_tmp_1 == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp_1);
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getIcon() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIcon());
        }
        stmt.bindLong(5, value.getId());
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        if (value.getToken() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getToken());
        }
        stmt.bindLong(8, value.getType());
        if (value.getUsername() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUsername());
        }
        stmt.bindLong(10, value.getId());
      }
    };
  }

  @Override
  public void insertAll(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertUser(final User element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteList(final List<User> elements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handleMultiple(elements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSome(final User... elements) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handleMultiple(elements);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User element) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(element);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public User findUserByName(final String name) {
    final String _sql = "select * from user where username=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfChapterTops = CursorUtil.getColumnIndexOrThrow(_cursor, "chapterTops");
      final int _cursorIndexOfCollectIds = CursorUtil.getColumnIndexOrThrow(_cursor, "collectIds");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfToken = CursorUtil.getColumnIndexOrThrow(_cursor, "token");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
      final User _result;
      if(_cursor.moveToFirst()) {
        final List<String> _tmpChapterTops;
        final String _tmp;
        _tmp = _cursor.getString(_cursorIndexOfChapterTops);
        _tmpChapterTops = __stringTypeConverter.stringToSomeObjectList(_tmp);
        final List<Integer> _tmpCollectIds;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfCollectIds);
        _tmpCollectIds = __integerConverter.integerToSomeObjectList(_tmp_1);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        final String _tmpToken;
        _tmpToken = _cursor.getString(_cursorIndexOfToken);
        final int _tmpType;
        _tmpType = _cursor.getInt(_cursorIndexOfType);
        final String _tmpUsername;
        _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
        _result = new User(_tmpChapterTops,_tmpCollectIds,_tmpEmail,_tmpIcon,_tmpId,_tmpPassword,_tmpToken,_tmpType,_tmpUsername);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
