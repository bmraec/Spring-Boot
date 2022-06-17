package com.balu.spring.id;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.util.CollectionUtils;

import com.balu.spring.entity.ProductEntity;

public class ProductIdGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String newId = "P-0001";
		CriteriaBuilder builder = session.getFactory().getCriteriaBuilder();
		CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
		Root<ProductEntity> root = query.from(ProductEntity.class);
		query.select(root).orderBy(builder.desc(root.get("pid")));

		Query q = session.createQuery(query);
		List resultList = q.setMaxResults(1).getResultList();
		if (!CollectionUtils.isEmpty(resultList)) {
			ProductEntity productEntity = (ProductEntity) resultList.get(0);
			String userId = productEntity.getPid();
			if (null != userId) {
				int id = Integer.parseInt(userId.substring(2));
				id++;
				if (id < 10) {
					newId = "P-000" + id;
				} else if (id < 100) {
					newId = "P-00" + id;
				} else if (id < 1000) {
					newId = "P-0" + id;
				} else {
					newId = "P-" + id;
				}
			}
		}
		return newId;
	}

}