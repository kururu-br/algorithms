/*
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┐
 * ReversePolishNotationApiApplication                                                                  |
 *                                                                                                      |
 * This is the application used to convert an expression infix to Reverse Polish Notation algorithm.    |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @author         Edson Martins   <edsonjam@gmail.com>                                                 |
 * @modifiedBy     Edson Martins   <edsonjam@gmail.com>                                                 |
 * @maintainedBy   Edson Martins   <edsonjam@gmail.com>                                                 |
 * @version        1.0                                                                                  |
 * @created        2019-08-14                                                                           |
 * @modified       2019-08-16                                                                           |
 * @systemLayer    Application                                                                          |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────|
 * @changes                                                                                             |
 * v1.0            edsonjam@gmail.com                                                                   |
 *                                                                                                      |
 * 2019-08-14      Initial version of ReversePolishNotationApiApplication                               |
 *                                                                                                      |
 * ─────────────────────────────────────────────────────────────────────────────────────────────────────┘
 */
package br.com.edson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReversePolishNotationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReversePolishNotationApiApplication.class, args);
	}

}
