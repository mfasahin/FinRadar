package com.finradar.android.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.finradar.android.data.local.entity.AlertEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlertDao_Impl implements AlertDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlertEntity> __insertionAdapterOfAlertEntity;

  public AlertDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlertEntity = new EntityInsertionAdapter<AlertEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `alerts` (`id`,`subscriptionId`,`subscriptionName`,`oldAmount`,`newAmount`,`percentageChange`,`isRead`,`date`,`type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlertEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getSubscriptionId());
        if (entity.getSubscriptionName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSubscriptionName());
        }
        statement.bindDouble(4, entity.getOldAmount());
        statement.bindDouble(5, entity.getNewAmount());
        statement.bindDouble(6, entity.getPercentageChange());
        final int _tmp = entity.isRead() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getDate());
        if (entity.getType() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getType());
        }
      }
    };
  }

  @Override
  public Object insertAlert(final AlertEntity alert, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAlertEntity.insertAndReturnId(alert);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AlertEntity>> getAllAlerts() {
    final String _sql = "SELECT * FROM alerts ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"alerts"}, new Callable<List<AlertEntity>>() {
      @Override
      @NonNull
      public List<AlertEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSubscriptionId = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionId");
          final int _cursorIndexOfSubscriptionName = CursorUtil.getColumnIndexOrThrow(_cursor, "subscriptionName");
          final int _cursorIndexOfOldAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "oldAmount");
          final int _cursorIndexOfNewAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "newAmount");
          final int _cursorIndexOfPercentageChange = CursorUtil.getColumnIndexOrThrow(_cursor, "percentageChange");
          final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final List<AlertEntity> _result = new ArrayList<AlertEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AlertEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpSubscriptionId;
            _tmpSubscriptionId = _cursor.getLong(_cursorIndexOfSubscriptionId);
            final String _tmpSubscriptionName;
            if (_cursor.isNull(_cursorIndexOfSubscriptionName)) {
              _tmpSubscriptionName = null;
            } else {
              _tmpSubscriptionName = _cursor.getString(_cursorIndexOfSubscriptionName);
            }
            final double _tmpOldAmount;
            _tmpOldAmount = _cursor.getDouble(_cursorIndexOfOldAmount);
            final double _tmpNewAmount;
            _tmpNewAmount = _cursor.getDouble(_cursorIndexOfNewAmount);
            final double _tmpPercentageChange;
            _tmpPercentageChange = _cursor.getDouble(_cursorIndexOfPercentageChange);
            final boolean _tmpIsRead;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp != 0;
            final long _tmpDate;
            _tmpDate = _cursor.getLong(_cursorIndexOfDate);
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            _item = new AlertEntity(_tmpId,_tmpSubscriptionId,_tmpSubscriptionName,_tmpOldAmount,_tmpNewAmount,_tmpPercentageChange,_tmpIsRead,_tmpDate,_tmpType);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getUnreadAlertCount() {
    final String _sql = "SELECT COUNT(*) FROM alerts WHERE isRead = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"alerts"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
