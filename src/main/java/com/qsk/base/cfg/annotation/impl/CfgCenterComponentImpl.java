package com.qsk.base.cfg.annotation.impl;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotationMetadata;

import com.qsk.base.cfg.annotation.CfgCenterBooleanValue;
import com.qsk.base.cfg.annotation.CfgCenterComponent;
import com.qsk.base.cfg.annotation.CfgCenterDoubleValue;
import com.qsk.base.cfg.annotation.CfgCenterIntegerValue;
import com.qsk.base.cfg.annotation.CfgCenterLongValue;
import com.qsk.base.cfg.annotation.CfgCenterStringValue;

@Order(1)
public class CfgCenterComponentImpl extends CfgCenterComponentSpringFactoryImportSelector<CfgCenterComponent> {

	private static Logger logger = LoggerFactory.getLogger(CfgCenterComponentImpl.class);
	
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		AnnotationAttributes attributes = AnnotationAttributes.fromMap(
				importingClassMetadata.getAnnotationAttributes(getAnnotationClass().getName(), true));
		
		try {
			initApplication(attributes , importingClassMetadata);
		} catch (Exception e) {
			logger.error("初始化对象失败，{}" , e.getMessage());
		}

		return new String[0];
	}
	
	private void initApplication(AnnotationAttributes attributes , AnnotationMetadata metadata) throws SecurityException, ClassNotFoundException {
		String service = resolvePlaceholders(attributes.getString("service"));
		String desc =  resolvePlaceholders(attributes.getString("desc"));
		
		logger.info("初始化配置中心数据 {} {}" , service , desc);
		
		Field [] fields = Class.forName(metadata.getClassName()).getDeclaredFields();
		for (int i = 0;i < fields.length ; i ++) {
			if (fields[i].isAnnotationPresent(CfgCenterStringValue.class)) {
				CfgCenterUpdComponent config = new CfgCenterUpdComponent();
				config.setClazz(metadata.getClassName());
				config.setDefaultValue(fields[i].getAnnotation(CfgCenterStringValue.class).defaultValue());
				config.setDesc(fields[i].getAnnotation(CfgCenterStringValue.class).desc());
				config.setField(fields[i]);
				config.setPropName(fields[i].getAnnotation(CfgCenterStringValue.class).propName());
				config.setService(service);
				
				CfgCenterComponentMgr.getInstance().addConfig(config);
			} else if (fields[i].isAnnotationPresent(CfgCenterIntegerValue.class)) {
				CfgCenterUpdComponent config = new CfgCenterUpdComponent();
				config.setClazz(metadata.getClassName());
				config.setDefaultValue(fields[i].getAnnotation(CfgCenterIntegerValue.class).defaultValue());
				config.setDesc(fields[i].getAnnotation(CfgCenterIntegerValue.class).desc());
				config.setField(fields[i]);
				config.setPropName(fields[i].getAnnotation(CfgCenterIntegerValue.class).propName());
				config.setService(service);
				
				CfgCenterComponentMgr.getInstance().addConfig(config);
			} else if (fields[i].isAnnotationPresent(CfgCenterLongValue.class)) {
				CfgCenterUpdComponent config = new CfgCenterUpdComponent();
				config.setClazz(metadata.getClassName());
				config.setDefaultValue(fields[i].getAnnotation(CfgCenterLongValue.class).defaultValue());
				config.setDesc(fields[i].getAnnotation(CfgCenterLongValue.class).desc());
				config.setField(fields[i]);
				config.setPropName(fields[i].getAnnotation(CfgCenterLongValue.class).propName());
				config.setService(service);
				
				CfgCenterComponentMgr.getInstance().addConfig(config);
			} else if (fields[i].isAnnotationPresent(CfgCenterDoubleValue.class)) {
				CfgCenterUpdComponent config = new CfgCenterUpdComponent();
				config.setClazz(metadata.getClassName());
				config.setDefaultValue(fields[i].getAnnotation(CfgCenterDoubleValue.class).defaultValue());
				config.setDesc(fields[i].getAnnotation(CfgCenterDoubleValue.class).desc());
				config.setField(fields[i]);
				config.setPropName(fields[i].getAnnotation(CfgCenterDoubleValue.class).propName());
				config.setService(service);
				
				CfgCenterComponentMgr.getInstance().addConfig(config);
			} else if (fields[i].isAnnotationPresent(CfgCenterBooleanValue.class)) {
				CfgCenterUpdComponent config = new CfgCenterUpdComponent();
				config.setClazz(metadata.getClassName());
				config.setDefaultValue(fields[i].getAnnotation(CfgCenterBooleanValue.class).defaultValue());
				config.setDesc(fields[i].getAnnotation(CfgCenterBooleanValue.class).desc());
				config.setField(fields[i]);
				config.setPropName(fields[i].getAnnotation(CfgCenterBooleanValue.class).propName());
				config.setService(service);
				
				CfgCenterComponentMgr.getInstance().addConfig(config);
			}
		}
	}
}
