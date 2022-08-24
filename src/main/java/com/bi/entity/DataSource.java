package com.bi.entity;


import com.bi.common.BaseEntity;
import com.bi.utils.EJBIUtils;
import com.rsbi.ext.engine.dao.DatabaseHelper;
import com.rsbi.ext.engine.view.context.ExtContext;
import com.rsbi.ext.engine.view.exception.ExtConfigException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author coder-zc
 * @date 2022年08月19日 22:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSource extends BaseEntity{

        private String linkType;
        private String linkName;
        private String linkPwd;
        private String linkUrl;
        private String dsName;
        private String jndiName;
        private String use; //使用jdbc/jndi
        private String dsId;

        /**
         * 获取驱动类
         * @return
         * @throws ExtConfigException
         */
        public String getClazz() throws ExtConfigException {
            String linktype = this.getLinkType();
            DatabaseHelper db = ExtContext.getInstance().getDatabaseHelper(linktype);
            return db.getClazz();
        }

        @Override
        public void validate() {
            this.dsName = EJBIUtils.htmlEscape(this.dsName);
            this.jndiName = EJBIUtils.htmlEscape(this.jndiName);
        }
    }

