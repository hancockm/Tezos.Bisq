/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.asset.coins;

import bisq.asset.AddressValidationResult;
import bisq.asset.AddressValidator;
import bisq.asset.Coin;

public class Tezos extends Coin {

    public Tezos() {
        super("TEZOS", "XTZ", new TezosAddressValidator());
    }


    public static class TezosAddressValidator implements AddressValidator {

        @Override
        public AddressValidationResult validate(String address) {
            // We only support addresses that begin with "tz" (transparent transactions)
            if (!address.startsWith("tz"))
                return AddressValidationResult.invalidAddress("", "validation.altcoin.zAddressesNotSupported");

            return AddressValidationResult.validAddress();
        }
    }
}
