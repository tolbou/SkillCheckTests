package com.example.demo.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 20, message = "名前は20桁以内で入力してください")
  private String name;
  /**
   * メール
   */
  @Email(message = "正しい形式で入力してください")
  @NotEmpty(message = "メールアドレスを入力してください")
  private String upn;
  

  @NotEmpty(message = "パスワードを入力してください")
  private String password;


}
//