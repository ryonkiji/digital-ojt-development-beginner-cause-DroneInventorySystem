package com.digitalojt.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalojt.web.entity.StockInfo;

/**
 * 在庫情報テーブルリポジトリー
 *
 * @author Okuma
 * 
 */
@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo, Integer> {

	/**
	 * 削除フラグが「0」の在庫情報を取得
	 * 
	 * @return
	 */
	@Query("SELECT s FROM StockInfo s WHERE s.deleteFlag = 0 ORDER BY stockId ASC")
	List<StockInfo> findAllActive();

	/**
	 * 引数に合致する在庫情報を取得
	 * 
	 * @param categoryId
	 * @param name   在庫名
	 * @param amount 個数
	 * @param range  以上か以下
	 * @return paramで検索した結果
	 */

	@Query("SELECT s FROM StockInfo s WHERE " +
			"(:categoryId IS NULL OR s.categoryInfo.categoryId = :categoryId) AND " +
			"(:name = '' OR s.name LIKE %:name%) AND " +
			"(:amount IS NULL OR (:range = 'OVER' AND s.amount >= :amount) OR (:range = 'UNDER' AND s.amount <= :amount)) AND "
			+
			"(s.deleteFlag = 0)")
	List<StockInfo> findByCategoryInfoCategoryIdAndNameAndAmount(
			Integer categoryId,
			String name,
			Integer amount,
			String range);

	/**
	 * センターIDに合致するの在庫情報を取得
	 * 
	 * @param centerId
	 * @return paramで検索した結果
	 */

	@Query("SELECT s FROM StockInfo s WHERE s.centerInfo.centerId = :centerId")
	List<StockInfo> findByCenterId(Integer centerId);

}