# Звіт до ЛР 5

1. Тема та варіант:** Варіант 3: Медичні установи і персонал. Успадкування в Java.

2. Обґрунтування коректності побудованої ієрархії:**
Зв'язок побудований за правильним принципом "є різновидом" (is-a). Кардіохірург є різновидом хірурга, хірург і педіатр є різновидами лікаря, а лікар — медичним працівником. Немає штучного успадкування заради повторного використання коду.

3. Пояснення ролі кожного рівня ієрархії:
- Рівень 1 (`MedicalWorker`): Базовий клас, що визначає загальні характеристики будь-якого працівника установи.
- Рівень 2 (`Doctor`): Спеціалізує працівника, визначаючи його саме як дипломованого лікаря.
- Рівень 3 (`Surgeon` та `Pediatrician`): Розгалуження в ширину. Розділяє лікарів за типом практики (хірургічна або дитяча терапія).
- Рівень 4 (`CardiacSurgeon`): Максимально вузька спеціалізація для конкретного типу операцій.

4. Власний стан кожного класу:
- `MedicalWorker`: додає `name`, `experienceYears`.
- `Doctor`: додає `licenseNumber`.
- `Surgeon`: додає `successfulSurgeries`.
- `Pediatrician`: додає `maxAgeLimit`.
- `CardiacSurgeon`: додає `certificationLevel`.

5. Коментар до JOL-виводу:
```text
ua.khpi.oop.lab05.model.CardiacSurgeon object internals:
OFF  SZ               TYPE DESCRIPTION                               VALUE
  0   8                    (object header: mark)                     0x0000000000000001 (non-biasable; age: 0)
  8   4                    (object header: class)                    0x01043250
 12   4                int MedicalWorker.experienceYears             10
 16   4   java.lang.String MedicalWorker.name                        (object)
 20   4   java.lang.String Doctor.licenseNumber                      (object)
 24   4                int Surgeon.successfulSurgeries               50
 28   4   java.lang.String CardiacSurgeon.certificationLevel         (object)
Instance size: 32 bytes