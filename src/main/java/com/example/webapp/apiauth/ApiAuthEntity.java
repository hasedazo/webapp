package com.example.webapp.apiauth;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
*API認証:エンティティ
*/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiAuthEntity {
	/** クライアントIPアドレス */
	private String clientIp;
	/** APIキー */
	private String apiKey;
	/** 認可対象業務 */
	private String ninka;
	/** 開始日時*/
	private LocalDateTime startAt;
	/** 更新日時*/
	private LocalDateTime endAt;
}