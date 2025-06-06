package com.digitalojt.web.form;

import com.digitalojt.web.validation.UpdateCenterInfoFormValidator;

import lombok.Data;

/**
 * 在庫センター情報詳細（更新/削除）画面のフォームクラス
 * 
 * @author Okuma
 *
 */
@Data
@UpdateCenterInfoFormValidator
public class UpdateCenterInfoForm {
	/**
	 * センターID
	 */
	private int centerId;

	/**
	 * センター名
	 */
	private String centerName;

	/**
	 * 郵便番号
	 */
	private String postCode;

	/**
	 * 住所
	 */
	private String address;

	/**
	 * 電話番号
	 */
	private String phoneNumber;

	/**
	 * 管理者名
	 */
	private String managerName;

	/**
	 * 稼働状況ステータス
	 */
	private int operationalStatus;

	/**
	 * 最大保管容量（m³）
	 */
	private String maxStorageCapacity;

	/**
	 * 現在保管容量（m³）
	 */
	private String currentStorageCapacity;

	/**
	 * 備考
	 */
	private String notes;

	/**
	 * 論理削除フラグ
	 */
	private String deleteFlag;

}
