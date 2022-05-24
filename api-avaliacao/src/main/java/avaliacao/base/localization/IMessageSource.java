package avaliacao.base.localization;

import java.util.Locale;

import avaliacao.base.exceptions.AppErrors;

public interface IMessageSource {
    String getMessage(String resource);

    String getMessage(String resource, Object[] params);

    String getMessage(AppErrors error);

    String getMessage(AppErrors error, Object[] params);

    String getMessage(Messages message);

    Locale getCurrentLocale();

    String getCurrentLocaleTag();
}
