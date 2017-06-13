/*
 * Copyright (c) 2017 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sweers.catchup.data.producthunt;

import com.serjltt.moshi.adapters.Wrapped;
import io.reactivex.Single;
import io.sweers.catchup.data.producthunt.model.Post;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Models the Product Hunt API. See https://api.producthunt.com/v1/docs
 */
public interface ProductHuntService {

  String SCHEME = "https";
  String HOST = "api.producthunt.com";
  String ENDPOINT = SCHEME + "://" + HOST;

  @GET("/v1/posts")
  @Wrapped(path = "posts")
  Single<List<Post>> getPosts(@Query("days_ago") int page);
}
