/* 프로젝트, 기부자(Activist), 대상자(Recipient)가 미 존재할 경우 발생
 * 
 */

package hotel.exception;

public class NotExistException extends Exception
{
	public NotExistException(){}
	public NotExistException(String message)
	{
		super(message);
	}
}
