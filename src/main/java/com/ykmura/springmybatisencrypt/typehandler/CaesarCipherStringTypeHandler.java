package com.ykmura.springmybatisencrypt.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import com.ykmura.springmybatisencrypt.cipher.CaesarCipher;

@MappedTypes(CaesarCipherStringType.class)
public class CaesarCipherStringTypeHandler extends BaseTypeHandler<String> {

    private final CaesarCipher caesarCipher;

    public CaesarCipherStringTypeHandler(CaesarCipher caesarCipher) {
        this.caesarCipher = caesarCipher;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        String str = caesarCipher.encipher(parameter);
        ps.setString(i, str);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        try {
            String str = rs.getString(columnName);
            if (str == null) {
                return null;
            }
            return caesarCipher.decipher(str);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            String str = rs.getString(columnIndex);
            if (str == null) {
                return null;
            }
            return caesarCipher.decipher(str);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            String str = cs.getString(columnIndex);
            if (str == null) {
                return null;
            }
            return caesarCipher.decipher(str);
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
