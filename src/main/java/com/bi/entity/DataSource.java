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

//        public String getLinkType() {
//            return linkType;
//        }
//        public void setLinkType(String linkType) {
//            this.linkType = linkType;
//        }
//        public String getLinkName() {
//            return linkName;
//        }
//        public void setLinkName(String linkName) {
//            this.linkName = linkName;
//        }
//        public String getLinkPwd() {
//            return linkPwd;
//        }
//        public void setLinkPwd(String linkPwd) {
//            this.linkPwd = linkPwd;
//        }
//        public String getLinkUrl() {
//            return linkUrl;
//        }
//        public void setLinkUrl(String linkUrl) {
//            this.linkUrl = linkUrl;
//        }
//        public String getDsname() {
//            return dsname;
//        }
//        public void setDsname(String dsname) {
//            this.dsname = dsname;
//        }
//
//        public String getJndiName() {
//            return jndiName;
//        }
//        public void setJndiName(String jndiName) {
//            this.jndiName = jndiName;
//        }
//        public String getUse() {
//            return use;
//        }
//        public void setUse(String use) {
//            this.use = use;
//        }
//        public String getDsid() {
//            return dsid;
//        }
//        public void setDsid(String dsid) {
//            this.dsid = dsid;
//        }

        @Override
        public void validate() {
            this.dsName = EJBIUtils.htmlEscape(this.dsName);
            this.jndiName = EJBIUtils.htmlEscape(this.jndiName);
        }
    }

